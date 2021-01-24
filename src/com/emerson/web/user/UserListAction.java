/*
 * @(#)UserListAction.java
 */
package com.emerson.web.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.emerson.business.UserService;

/**
 * UserListAction Class <br/>
 * The Action class for displaying the list of Users
 *
 * @author PatrickHarvey.Sy
 * $Date: 2017/01/23 10:19:25 $
 */
public class UserListAction extends UserAction {

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
    public ActionForward doPerform(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        //cast form
        UserSearchForm searchForm = (UserSearchForm) form;
        //create an instance of UserService
        UserService service = new UserService();

        try {
            searchForm.setUserList(service.getUsers());
        } catch (Exception e) {
            ActionErrors errors = new ActionErrors();
            errors.add("result", new ActionError(e.getMessage()));
            saveErrors(request, errors);
        }

        //Forward to the appropriate View
        return mapping.findForward("success");
    }
}