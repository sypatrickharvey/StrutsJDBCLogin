/*
 * @(#)UserSearchForm.java
 *
 * Copyright 2006 Sumitomo Heavy Industries, Ltd. All Rights Reserved.
 *
 * This software is the proprietary information of
 * Sumitomo Heavy Industries, Ltd. All Rights Reserved.
 * Use is subject to license terms.
 */
package com.emerson.web.user;

import org.apache.struts.action.ActionForm;

import java.util.List;

/**
 * UserSearchForm Class<br/>
 *
 * @author Patrick Harvey Sy
 * @author last modified by: $Author: Patrick Harvey Sy $
 * @version $Revision: 1.1 $ $Date: 2008/03/12  $
 */
public class UserSearchForm extends ActionForm {
    /** list of user's */
    private List userList;

    /**
     * set list of users
     * @param employeeList
     */
    public void setUserList(List userList) {
        this.userList = userList;
    }

    /**
     * get the list of user
     * @return list of user
     */
    public List getUserList() {
        return  this.userList;
    }
}
