/*
 * @(#)LoginViewAction.java
 *
 * Copyright 2006 Sumitomo Heavy Industries, Ltd. All Rights Reserved.
 *
 * This software is the proprietary information of
 * Sumitomo Heavy Industries, Ltd. All Rights Reserved.
 * Use is subject to license terms.
 */
package com.emerson.web.user;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * LoginViewAction Class<br/>
 *
 * @author PatrickHarvey.Sy
 * $Date: 2017/01/23 10:19:25 $
 */
public class LoginViewAction extends Action {
    /**
     * process the specified HTTP request, and create the corresponding
     * HTTP response with provision for handling exceptions. <br/>
     *
     * @param mapping  the ActionMapping
     * @param form     the ActionForm
     * @param request  the HttpServletRequest
     * @param response the HttpServletResponse
     * @return forward the appropriate view
     * @throws java.io.IOException
     * @throws javax.servlet.ServletException
     */
    public ActionForward perform(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

    	System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>. success");
        // Forward to the appropriate View
        return mapping.findForward("success");
    }
}
