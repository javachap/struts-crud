
package com.javachap.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.javachap.domain.Lead;
import com.javachap.domain.User;
import com.javachap.service.LeadService;
import com.javachap.service.ServiceUtils;
import com.javachap.web.model.LeadListingForm;

public class LeadListingAction extends SecuredAction {

    public ActionForward lmsExecute(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {

        LeadListingForm leadListingForm = (LeadListingForm) form;

        if (("delete").equalsIgnoreCase(leadListingForm.getAction())) {

            Long leadId = leadListingForm.getLeadId();
            delete(leadId, request);

        }
        else if (("deleteLeads").equalsIgnoreCase(leadListingForm.getAction())) {
            String[] leadIds = leadListingForm.getLeadIds();
            for (String leadIdString : leadIds) {

                Long leadId = Long.parseLong(leadIdString);
                delete(leadId, request);
            }
        }

        User user = (User) request.getSession().getAttribute("user");
        List<Lead> leadList = ServiceUtils.getLeadService().getLeadsByUser(user);
        request.setAttribute("leadList", leadList);

        return mapping.getInputForward();
    }

    public void delete(Long leadId, HttpServletRequest request) {
        LeadService leadService = ServiceUtils.getLeadService();
        boolean deleteSuccessfull = false;
        if(leadId != null && leadId > 0) {
            Lead lead = leadService.getLead(leadId);
            if (lead != null) {
                leadService.delete(lead);
                ActionMessages messages = new ActionMessages();
                messages.add(ActionMessages.GLOBAL_MESSAGE,
                                new ActionMessage("message.lead.delete"));
                saveMessages(request, messages);
                deleteSuccessfull = true;
            }
        }
        if(!deleteSuccessfull) {
            ActionErrors errors = new ActionErrors();
            errors.add(ActionErrors.GLOBAL_MESSAGE,
                        new ActionMessage("error.lead.deleted"));
            saveErrors(request, errors);
        }
    }
}
