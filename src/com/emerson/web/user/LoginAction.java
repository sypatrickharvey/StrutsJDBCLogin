/*
 * @(#)LoginAction.java
 */
package com.emerson.web.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.emerson.business.UserService;
import com.emerson.value.user.UserValue;

/**
 * LoginAction Class <br/>
 *
 * @author PatrickHarvey.Sy
 * $Date: 2017/01/23 10:19:25 $
 */

public class LoginAction extends Action {
    /**
     * process the specified HTTP request, and create the corresponding
     * HTTP response with provision for handling exceptions. <br/>
     *
     * @param mapping  the ActionMapping
     * @param form     the ActionForm
     * @param request  the HttpServletRequest
     * @param response the HttpServletResponse
     * @return forward the appropriate view
     * @throws IOException
     * @throws ServletException
     */
    public ActionForward perform(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        // Default target to success
        ActionForward forward = mapping.findForward("success");

        // Use the LoginForm to get the request parameters
        LoginForm loginForm = (LoginForm) form;
        String username = loginForm.getUsername();
        String password = loginForm.getPassword();
        //create an instance of EmployeeService
        UserService service = new UserService();
        //create an instance of UserValue
        UserValue userValue = new UserValue();
        //check if login is OK
        boolean loginOk = service.checkUser(username, password);

        if (loginOk) {
        	try{

            //create an instance of UserService
            UserService userService = new UserService();
        	UserValue value = userService.getUser(username);

        	String role = String.valueOf(value.getRoleid());

        	//set username and roleid to the session object
            HttpSession session = request.getSession();
            session.setAttribute("USER", username);
		    session.setAttribute("ROLEID",role);

            System.out.println("Set to session Username=" + username +" role Id=" + role );

        	} catch ( Exception e ){
        	System.out.println("username not found");
        	}
        } else {
            forward = new ActionForward(mapping.getInput());
            ActionErrors errors = new ActionErrors();

            errors.add("result", new ActionError("errors.login.unknown"));
            saveErrors(request, errors);
        }

        // Forward to the appropriate View
        return forward;
    }
}