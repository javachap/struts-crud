
package com.javachap.web.controller;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionErrors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javachap.domain.User;
import com.javachap.service.ServiceUtils;
import com.javachap.web.model.LoginForm;

public class LoginAction extends Action {

    public ActionForward execute(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        LoginForm loginForm = (LoginForm) form;
        String action = loginForm.getAction();
        ActionForward forward = mapping.getInputForward();
        if (("login").equalsIgnoreCase(action)) {
            String email = loginForm.getEmail();
            String password = loginForm.getPassword();
            User user = ServiceUtils.getUserService().authenticate(email, password);
            if (user != null) {
                request.getSession(true).setAttribute("user", user);
                forward = mapping.findForward("home");
            }
            else {
                ActionErrors errors = new ActionErrors();
                errors.add(ActionErrors.GLOBAL_MESSAGE,
                           new ActionMessage("error.login.failed"));
                saveErrors(request, errors);
            }
        }
        return forward;
    }
}
