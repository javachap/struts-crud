package com.javachap.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Base Domain Object
 * @author Varma
 */

public interface Domain extends Serializable {

	void setId(Long id);
	
	Long getId();
	
	void setCreatedDate(Date createdDate);
	
	Date getCreatedDate();
	
	void setModifiedDate(Date modifiedDate);
	
	Date getModifiedDate();
}
