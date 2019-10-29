package com.javachap.web.model;

public class LeadListingForm extends BaseForm {

	private static final long serialVersionUID = -6519972467246625078L;

	/**
     * LeadId
     */
    protected Long leadId = null;

    public void setLeadId(Long leadId){
        this.leadId = leadId;
    }

    public Long getLeadId(){
       return (this.leadId);
    }


    /**
     * LeadIds
     */
    protected String[] leadIds = null;

    public void setLeadIds(String[] leadIds){
        this.leadIds = leadIds;
    }

    public String[] getLeadIds(){
       return (this.leadIds);
    }

}
