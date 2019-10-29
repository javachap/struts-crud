package com.javachap.domain.impl;

import com.javachap.domain.User;

public class UserImpl extends DomainImpl implements User {
	
	private static final long serialVersionUID = 7487133273442955818L;
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;	
	
	/* (non-Javadoc)
	 * @see com.javachap.domain.impl.User#getFirstName()
	 */
	public String getFirstName() {
		return firstName;
	}
	/* (non-Javadoc)
	 * @see com.javachap.domain.impl.User#setFirstName(java.lang.String)
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/* (non-Javadoc)
	 * @see com.javachap.domain.impl.User#getLastName()
	 */
	public String getLastName() {
		return lastName;
	}	
	/* (non-Javadoc)
	 * @see com.javachap.domain.impl.User#setLastName(java.lang.String)
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/* (non-Javadoc)
	 * @see com.javachap.domain.impl.User#getEmail()
	 */
	public String getEmail() {
		return email;
	}
	/* (non-Javadoc)
	 * @see com.javachap.domain.impl.User#setEmail(java.lang.String)
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/* (non-Javadoc)
	 * @see com.javachap.domain.impl.User#getPassword()
	 */
	public String getPassword() {
		return password;
	}
	/* (non-Javadoc)
	 * @see com.javachap.domain.impl.User#setPassword(java.lang.String)
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("UserImpl[");
		buffer.append("id = ").append(id);
		buffer.append(" email = ").append(email);
		buffer.append(" firstName = ").append(firstName);
		buffer.append(" lastName = ").append(lastName);
		buffer.append(" password = ").append(password);
		buffer.append("]");
		return buffer.toString();
	}
}
