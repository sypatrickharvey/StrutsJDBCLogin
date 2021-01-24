/*
 * @(#)UserValue.java
 */
package com.emerson.value.user;

/**
 *
 * UserValue Class <br/>
 *
 * @author PatrickHarvey.Sy
 * $Date: 2017/01/23 10:19:25 $
 */
public class UserValue {

    /** user name */
    private String username;
    /** password */
    private String password;
    /** name */
    private String name;
    /** role name*/
    private String rolename;
    /** phone number */
    /** role id */
    private Integer roleid;

    /**
     * setter method for user name
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * accessor method for user name
     * @return user name
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * setter method for password
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * accessor method for password
     * @return password
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * setter method for employee's name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * accessor method for user's name
     * @return employee's name
     */
    public String getName() {
        return this.name;
    }


    /**
     * setter method for role name
     * @param rolename
     */
    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    /**
     * accessor method for rolename
     * @return role name
     */
    public String getRolename() {
        return this.rolename;
    }


    /**
     * setter method for roleid
     * @param roleid
     */
    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    /**
     * accessor method for role id
     * @return role id
     */
    public Integer getRoleid() {
        return this.roleid;
    }
}