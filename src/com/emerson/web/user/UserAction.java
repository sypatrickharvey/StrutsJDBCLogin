/*
 * @(#)UserAction.java
 */
package com.emerson.web.user;

import org.apache.struts.action.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * UserAction Class <br/>
 * The superclass of Action class <br/>
 *
 * @author PatrickHarvey.Sy
 * $Date: 2017/01/23 10:19:25 $
 */
public abstract class UserAction extends Action {

    /**
     * process the specified HTTP request, and create the corresponding
     * HTTP response with provision for handling exceptions. <br/>
     *
     * @param mapping the ActionMapping
     * @param form the ActionForm
     * @param request the HttpServletRequest
     * @param response the HttpServletResponse
     *
     * @return forward the appropriate view
     * @throws IOException
     * @throws ServletException
     */
    public ActionForward perform(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {

        //get the current session
        HttpSession session = request.getSession();
        if (session.getAttribute("USER") == null ) {
            // The user is not logged in
            ActionErrors errors = new ActionErrors();

            errors.add(ActionErrors.GLOBAL_ERROR,
                    new ActionError("errors.login.required"));

            // Report any errors we have discovered back
            // to the original form
            saveErrors(request, errors);

            //return to login page
            return mapping.findForward("login");
        }

        //return appropriate view
        return doPerform(mapping, form, request, response);
    }

    /**
     * abstract method process the specified HTTP request, and create the
     * corresponding HTTP response with provision for handling exceptions. <br/>
     *
     * @param mapping the ActionMapping
     * @param form the ActionForm
     * @param request the HttpServletRequest
     * @param response the HttpServletResponse
     *
     * @return forward the appropriate view
     * @throws IOException
     * @throws ServletException
     */
    protected abstract ActionForward doPerform(ActionMapping mapping,
            ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException;

}