/*
 * @(#)UserValueUtil.java
 */
package com.emerson.value.user;

import com.emerson.web.user.UserForm;

/**
 *
 * UserValueUtil Class <br/>
 * Utility for transferring values from Form to Value (Vice-versa)
 *
 * @author PatrickHarvey.Sy
 * $Date: 2017/01/23 10:19:25 $
 */
public class UserValueUtil {

    /**
     * transfer the contents of value to form
     *
     * @param value
     * @param form
     */
    public static void transferValueToForm(UserValue value,
            UserForm form) {


        form.setName(value.getName());
        form.setPassword(value.getPassword());
        form.setRoleid(String.valueOf(value.getRoleid()));
        form.setUsername(value.getUsername());


    }

    /**
     * transfer the contents of form to value
     * @param form
     * @param value
     */
    public static void transferFormToValue(UserForm form,
            UserValue value) {


        value.setName(form.getName());
        value.setPassword(form.getPassword());
        value.setRoleid(new Integer(form.getRoleid()));
        value.setUsername(form.getUsername());
    }
}
