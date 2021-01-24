/*
 * @(#)UserForm.java
 */
package com.emerson.web.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.emerson.business.UserService;

/**
 *
 * UserForm Class <br/>
 *
 * @author PatrickHarvey.Sy
 * $Date: 2017/01/23 10:19:25 $
 */
public class UserForm extends ActionForm {

    /** user name */
    private String username;
    /** password */
    private String password;
    /** employee's name */
    private String name;
    /** role id */
    private String roleid;

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
     * set the value of password
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * get the value of password
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * set the value of user's name
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
     * set the value of role id
     * @param roleid
     */
    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    /**
     * get the value of role id
     * @return role id
     */
    public String getRoleid() {
        return roleid;
    }

     /**
     * get the list of role
     * @return the list of role
     */
    public List getRoleList() {
        UserService service = new UserService();
        return service.getRoles();
    }



    /**
     * This method is called with every request. It resets the Form
     * attribute prior to setting the values in the new request.
     *
     * @param mapping
     * @param request
     */
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        this.username = null;
        this.password = null;
        this.name = null;
        this.roleid = null;
	}

    /**
     * This method is called prior to action when validate is true in
     * struts-config.xml
     *
     * @param mapping
     * @param request
     *
     * @return ActionErrors
     */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {

        ActionErrors errors = new ActionErrors();

        //validate input values
        if (this.roleid == null || this.roleid.length() == 0) {
            errors.add("result", new ActionError("errors.roleid.required"));
        }

        if (this.name == null || this.name.length() == 0) {
            errors.add("result", new ActionError("errors.name.required"));
        }

        if (this.password == null || this.password.length() == 0) {
            errors.add("result", new ActionError("errors.password.required"));
        }

        if (this.username == null || this.username.length() == 0) {
            errors.add("result", new ActionError("errors.username.required"));
        }

        return errors;
    }
}