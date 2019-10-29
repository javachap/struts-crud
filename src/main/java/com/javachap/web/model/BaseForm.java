package com.javachap.web.model;

import org.apache.struts.action.ActionForm;

public class BaseForm extends ActionForm {

	private static final long serialVersionUID = -3298183685105683583L;

	/**
     * Action
     */
    protected String action = null;

    public void setAction(String action){
        this.action = action;
    }

    public String getAction(){
       return (this.action);
    }

}
