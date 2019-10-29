package com.javachap.web.model;

import org.apache.struts.action.ActionForm;

public class LanguageForm extends ActionForm {

	private static final long serialVersionUID = 8251763900079001162L;

	private String language;

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

}
