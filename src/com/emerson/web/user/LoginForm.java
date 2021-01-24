/*
 * @(#)LoginForm.java
 */
package com.emerson.web.user;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * LoginForm Class <br/>
 *
 * @author PatrickHarvey.Sy
 * $Date: 2017/01/23 10:19:25 $
 */
public class LoginForm extends ActionForm {

    /** password */
    private String password;
    /** user name */
    private String username;

    /**
     * accessor method for password
     * @return password
     */
    public String getPassword() {
		return this.password;
	}

    /**
     * setter method for password
     * @param password
     */
    public void setPassword(String password) {
	    this.password = password;
	}

	/**
     * accessor method for username
	 * @return username
	 */
    public String getUsername() {
	    return this.username;
	}

    /**
     * setter method for username
     * @param username
     */
    public void setUsername(String username) {
	    this.username = username;
	}

    /**
     * This method is called with every request. It resets the Form
     * attribute prior to setting the values in the new request.
     *
     * @param mapping
     * @param request
     */
    public void reset(ActionMapping mapping, HttpServletRequest request) {
	    this.password = null;
	    this.username = null;
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
    public ActionErrors validate(ActionMapping mapping,
            HttpServletRequest request) {

        ActionErrors errors = new ActionErrors();

        if ((username == null) || (username.length() == 0)) {
            errors.add("username", new ActionError("error.mandatory"));
        }
        if ((password == null) || (password.length() == 0)) {
            errors.add("password", new ActionError("error.mandatory"));
        }
        return errors;
    }
}