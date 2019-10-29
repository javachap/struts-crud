package com.javachap.domain.impl;

import java.util.Date;

import com.javachap.domain.Domain;

public abstract class DomainImpl implements Domain {
	
	private static final long serialVersionUID = 2893016007831099035L;
	
	protected Long id;
	protected Date createdDate;
	protected Date modifiedDate;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}	
}
