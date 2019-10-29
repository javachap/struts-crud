package com.javachap.service;

import java.util.List;

import com.javachap.domain.Lead;
import com.javachap.domain.User;

public interface LeadService extends Service {

	Lead getLead(Long id);
	
	Lead save(Lead lead);
	
	void delete(Lead lead);
	
	List<Lead> getLeadsByUser(User user);	
}
