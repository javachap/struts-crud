package com.javachap.web.controller;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionErrors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class SecuredAction extends Action {

    public final ActionForward execute(ActionMapping mapping,
                                       ActionForm form,
                                       HttpServletRequest request,
                                       HttpServletResponse response) {

        ActionForward forward = null;
        if (request.getSession().getAttribute("user") != null) {
            forward = lmsExecute(mapping, form, request, response);
        }
        else {
            ActionErrors errors = new ActionErrors();
            errors.add(ActionErrors.GLOBAL_MESSAGE,
                       new ActionMessage("error.label.authRequired"));
            saveErrors(request, errors);
            forward = mapping.findForward("login");
        }
        return forward;
    }

    public abstract ActionForward lmsExecute(ActionMapping mapping,
                                             ActionForm form,
                                             HttpServletRequest request,
                                             HttpServletResponse response);

}

