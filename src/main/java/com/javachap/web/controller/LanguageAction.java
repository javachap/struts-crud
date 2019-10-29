
package com.javachap.web.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.javachap.web.model.LanguageForm;

public class LanguageAction extends Action {

    public ActionForward execute(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        LanguageForm languageForm = (LanguageForm) form;
        Locale locale = null;
        if (("french").equals(languageForm.getLanguage())) {
            locale = Locale.FRENCH;
        }
        else {
            locale = Locale.ENGLISH;
        }
        request.getSession().setAttribute("display", locale);
        ActionForward forward = mapping.findForward("leadListing");
        return forward;
    }
}