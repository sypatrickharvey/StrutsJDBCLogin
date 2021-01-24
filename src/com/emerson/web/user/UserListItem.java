/*
 * @(#)UserListItem.java
 */
package com.emerson.web.user;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * UserListItem Class <br/>
 *
 * @author PatrickHarvey.Sy
 * $Date: 2017/01/23 10:19:25 $
 */
public class UserListItem {

    /** user name */
    private String username;
    /** employee name */
    private String name;
    /** department */
    private String department;
    /** role name */
    private String rolename;
    /** telephone number */
    private String phone;
    /** email address*/
    private String email;
    /** link data */
    private Map linkDataMap;

    /**
     * retrieve the link data
     * @return the link data
     */
    public Map getLinkDataMap() {
        this.linkDataMap = new HashMap();
        this.linkDataMap.put("username", this.getUsername());
        return this.linkDataMap;
    }

    /**
     * set the value of username
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * get the value of username
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * set the user's name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get the value of user's name
     * @return employee's name
     */
    public String getName() {
        return name;
    }

    /**
     * set the value of rolename
     * @param rolename
     */
    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    /**
     * get the value of rolename
     * @return rolename
     */
    public String getRolename() {
        return rolename;
    }

}