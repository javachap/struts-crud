
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

import com.javachap.domain.Category;
import com.javachap.domain.Lead;
import com.javachap.domain.User;
import com.javachap.domain.impl.LeadImpl;
import com.javachap.service.LeadService;
import com.javachap.service.ServiceUtils;
import com.javachap.web.model.LeadForm;

public class LeadAction extends SecuredAction {

    public ActionForward lmsExecute(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        LeadForm leadForm = (LeadForm) form;
        ActionForward forward = null;

        List<Category> categoryList = ServiceUtils.getCategoryService().getAllCategories();
        request.setAttribute("categoryList", categoryList);

        System.out.println(leadForm.getAction());
        if (("save").equals(leadForm.getAction())) {
            ActionErrors errors = new ActionErrors();
            if (("Select any Category").equals(leadForm.getCategory())) {
                errors.add("category", new ActionMessage("error.label.mandetory"));
            }
            if (leadForm.getTitle().trim().length() < 1 || leadForm.getTitle() == null) {
                errors.add("title", new ActionMessage("error.label.mandetory"));
            }
            if (leadForm.getDescription().trim().length() < 1 || leadForm.getDescription() == null) {
                errors.add("description", new ActionMessage("error.label.mandetory"));
            }
            if (leadForm.getFirstName().trim().length() < 1 || leadForm.getFirstName() == null) {
                errors.add("firstName", new ActionMessage("error.label.mandetory"));
            }
            if (leadForm.getLastName().trim().length() < 1 || leadForm.getLastName() == null) {
                errors.add("lastName", new ActionMessage("error.label.mandetory"));
            }
            if (leadForm.getEmail().trim().length() < 1 || leadForm.getEmail() == null) {
                errors.add("email", new ActionMessage("error.label.mandetory"));
            }
            if (leadForm.getPrice().trim().length() < 1 || leadForm.getPrice() == null) {
                errors.add("price", new ActionMessage("error.label.mandetory"));
            }
            else {
                try {
                    float priceValue = Float.parseFloat(leadForm.getPrice());
                    if (priceValue < 0) {
                        errors.add("price", new ActionMessage("error.label.greaterThanZero"));
                    }
                }
                catch (NumberFormatException numberFormatException) {
                    errors.add("price", new ActionMessage("error.label.numberOnly"));
                }
            }
            if (!errors.isEmpty()) {
                saveErrors(request, errors);
                forward = mapping.findForward("leadCreateEdit");
            }
            else {
                User user = (User) request.getSession().getAttribute("user");
                Lead lead = null;
                LeadService leadService = ServiceUtils.getLeadService();
                Long leadId = leadForm.getLeadId();
                if (leadId != null && leadId > 0) {
                    lead = leadService.getLead(leadId);
                    ActionMessages messages = new ActionMessages();
                    messages.add(ActionMessages.GLOBAL_MESSAGE,
                                 new ActionMessage("message.lead.update"));
                    saveMessages(request, messages);
                }
                else {
                    lead = new LeadImpl();
                    lead.setStatus(Lead.Status.New.toString());
                    ActionMessages messages = new ActionMessages();
                    messages.add(ActionMessages.GLOBAL_MESSAGE,
                                 new ActionMessage("message.lead.insert"));
                    saveMessages(request, messages);
                }
                Long categoryId = Long.parseLong(leadForm.getCategory());
                System.out.println(categoryId);
                Category category = ServiceUtils.getCategoryService().getCategory(categoryId);
                System.out.println(category.getId());
                lead.setCategory(category);
                lead.setTitle(leadForm.getTitle());
                lead.setDescription(leadForm.getDescription());
                lead.setFirstName(leadForm.getFirstName());
                lead.setLastName(leadForm.getLastName());
                lead.setEmail(leadForm.getEmail());
                lead.setPhone(leadForm.getPhone());
                lead.setPrice(Float.parseFloat(leadForm.getPrice()));
                lead.setOwner(user);
                lead = leadService.save(lead);
                forward = mapping.findForward("home");
            }
        }
        else if (("cancel").equalsIgnoreCase(leadForm.getAction())) {
            forward = mapping.findForward("home");
        }
        else if (("edit").equalsIgnoreCase(leadForm.getAction())) {
            Long leadId = leadForm.getLeadId();
            Lead lead = ServiceUtils.getLeadService().getLead(leadId);
            String id = String.valueOf(ServiceUtils.getCategoryService().getCategory(lead.getCategory().getId()).getId());
            leadForm.setCategory(id);
            leadForm.setTitle(lead.getTitle());
            leadForm.setDescription(lead.getDescription());
            leadForm.setFirstName(lead.getFirstName());
            leadForm.setLastName(lead.getLastName());
            leadForm.setEmail(lead.getEmail());
            leadForm.setPhone(lead.getPhone());
            leadForm.setPrice(String.valueOf(lead.getPrice()));
            leadForm.setLeadId(leadId);
            forward = mapping.findForward("leadCreateEdit");
        }
        else if (("delete").equalsIgnoreCase(leadForm.getAction())) {
            leadForm.setAction(leadForm.getAction());
            leadForm.setLeadId(leadForm.getLeadId());
            forward = mapping.findForward("home");
        }
        else if (("publish").equalsIgnoreCase(leadForm.getAction())) {
            LeadService leadService = ServiceUtils.getLeadService();
            Lead lead = leadService.getLead( leadForm.getLeadId() );
            lead.setStatus(Lead.Status.Published.toString());
            lead = leadService.save(lead);
            ActionMessages messages = new ActionMessages();
                    messages.add(ActionMessages.GLOBAL_MESSAGE,
                                 new ActionMessage("message.lead.publish"));
                    saveMessages(request, messages);
            forward = mapping.findForward("home");
        }
        else if (leadForm.getLeadId() != null) {
            Lead lead = ServiceUtils.getLeadService().getLead(leadForm.getLeadId());
            request.setAttribute("lead", lead);
            forward = mapping.getInputForward();
        }
        else {
            forward = mapping.findForward("leadCreateEdit");
        }
        return forward;
    }
}
