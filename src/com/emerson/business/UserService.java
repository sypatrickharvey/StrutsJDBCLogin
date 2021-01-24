/*
 * @(#)UserService.java
 */
package com.emerson.business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.emerson.DBAccessUtil;
import com.emerson.value.user.LabelValue;
import com.emerson.value.user.UserValue;
import com.emerson.web.user.UserListItem;

/**
 * UserService Class <br/>
 *
 * @author PatrickHarvey.Sy
 * $Date: 2017/01/23 10:19:25 $
 */
public class UserService {
    /**
     * Connection Object
     */
    private Connection con;

    /**
     * Constructor
     */
    public UserService() {
        con = DBAccessUtil.getInstance().getConnection();
    }

    /**
     * adds new record in tblUser table
     *
     * @param value contains the data to be inserted
     * @throws Exception when record not found
     */
    public void insertUser(UserValue value) throws Exception {
        try {
            if (this.isFound(value.getUsername())) {
                throw new Exception("error.duplicate.data");
            }

            String sql = "insert into tblUser values (?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, value.getUsername());
            stmt.setString(2, value.getPassword());
            stmt.setInt(3, value.getRoleid().intValue());
            stmt.setString(4, value.getName());


            //insert the record into the table
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("UserService#insertUser:" + ex.getMessage());
            throw new RuntimeException(ex);
        } finally {
            DBAccessUtil.getInstance().close(con);
        }
    }

    /**
     * deletes a record in tblUser table
     *
     * @param username the key for deleting
     * @throws Exception when record not found
     */
    public void deleteUser(String username) throws Exception {

        try {
            if (!this.isFound(username)) {
                throw new Exception("error.record.not.found");
            }

            String sql = "delete from tblUser where username=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, username);

            //delete record
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("UserService#deleteUser:" + ex.toString());
            throw new RuntimeException(ex);
        } finally {
            DBAccessUtil.getInstance().close(con);
        }
    }

    /**
     * modify the contents of tblUser table
     *
     * @param value contains information of User
     * @throws Exception when record not found
     */
    public void updateUser(UserValue value) throws Exception {

        try {
            if (!this.isFound(value.getUsername())) {
                throw new Exception("error.record.not.found");
            }

            //if no exception encountered from the previous statement, proceed.
            StringBuffer sql = new StringBuffer("update tblUser set password=?,");
            sql.append("roleid=?,name=? ");
            sql.append("where username=?");

            PreparedStatement stmt = con.prepareStatement(sql.toString());
            //set the values of ?
            stmt.setString(1, value.getPassword());
            stmt.setInt(2, value.getRoleid());
            stmt.setString(3, value.getName());
            stmt.setString(4, value.getUsername());

            //update the record
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("UserService#updateUser:" + ex.getMessage());
            throw new RuntimeException(ex);
        } finally {
            DBAccessUtil.getInstance().close(con);
        }
    }

    /**
     * retrieve all the contents of tblUser Table
     *
     * @return List of Users in UserListItem type
     * @throws Exception when no record found.
     */
    public List getUsers() throws Exception {

        List users = new ArrayList();
        ResultSet rs = null;
        Statement stmt = null;

        try {
            int recCount = 0;
            stmt = con.createStatement();
            String cond = " where tbluser.roleid=tblroles.roleid ";

            String sqlCount = "select count(*) from tbluser, tblroles" + cond;
            System.out.println("sqlCount = " + sqlCount);
            rs = stmt.executeQuery(sqlCount);
            if (rs.next()) {
                recCount = rs.getInt(1);
            }

            if (recCount == 0) {
                System.err.println("-- No Record Found --");
                throw new Exception("error.record.not.found");
            }

            String sql = "select * from tbluser, tblroles" + cond;
            System.out.println("sql = " + sql);
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                //create new item object that will be added to the list.
                UserListItem user = new UserListItem();

                user.setUsername(rs.getString("username"));
                user.setName(rs.getString("name"));
                user.setRolename(rs.getString("rolename"));

                users.add(user);
            }

        } catch (SQLException e) {
            System.err.println("UserService#getUser" + e.getMessage());
            throw new RuntimeException(e);
        } finally {
            DBAccessUtil.getInstance().close(con, stmt, rs);
        }

        return users;
    }

    /**
     * check validity of user's login information
     *
     * @param username User name
     * @param password Password
     * @return
     */
    public boolean checkUser(String username, String password) {

        ResultSet rs = null;
        PreparedStatement stmt = null;
        boolean result = false;

        try {
            String sql = "select * from tblUser where username=? and password=?";

            stmt = con.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);

            rs = stmt.executeQuery();
            result = rs.next();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        } finally {
            DBAccessUtil.getInstance().close(con, stmt, rs);
        }

        return result;
    }

    /**
     * retrieve one record from User table
     *
     * @param username User Name
     * @return User Information
     * @throws Exception when record not found
     */
    public UserValue getUser(String username) throws Exception {

        ResultSet rs = null;
        PreparedStatement stmt = null;
        UserValue value = new UserValue();

        try {
            String sql = "select * from tblUser where username=?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, username);

            rs = stmt.executeQuery();
            if (rs.next()) {
                value.setUsername(rs.getString("username"));
                value.setPassword(rs.getString("password"));
                value.setRoleid(new Integer(rs.getInt("roleid")));
                value.setName(rs.getString("name"));
            } else {
                System.err.println("User#getUser:No Record Found");
                throw new Exception("error.record.not.found");


            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        } finally {
            DBAccessUtil.getInstance().close(con, stmt, rs);
        }

        return value;
    }

    /**
     * check if a record exists in User table
     *
     * @param username User name
     * @return true if found, otherwise, false
     */
    private boolean isFound(String username) {
        boolean result = false;
        try {
            String sql = "select * from tblUser where username=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, username);

            ResultSet rs = stmt.executeQuery();
            result = rs.next();

        } catch (SQLException ex) {
            System.err.println("Error> " + ex.toString());
        }
        return result;
    }


    /**
     * retrieve all the contents of Role table
     *
     * @return list of roles
     */
    public List getRoles() {
        List roles = new ArrayList();
        ResultSet rs = null;
        Statement stmt = null;

        try {
            stmt = con.createStatement();
            String sql = "select * from tblroles";

            rs = stmt.executeQuery(sql);

            LabelValue labelValue = new LabelValue();
            labelValue.setLabel("");
            labelValue.setValue("");
            roles.add(labelValue);
            while (rs.next()) {
                labelValue = new LabelValue();
                labelValue.setLabel(rs.getString("rolename"));
                labelValue.setValue(rs.getString("roleid"));
                roles.add(labelValue);
            }
        } catch (SQLException e) {
            System.err.println("UserService#getRoles" + e.getMessage());
        } finally {
            DBAccessUtil.getInstance().close(con, stmt, rs);
        }
        return roles;
    }


}