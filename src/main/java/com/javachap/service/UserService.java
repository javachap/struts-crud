package com.javachap.service;

import com.javachap.domain.User;

/**
 * UserService
 * @author Varma
 */

public interface UserService extends Service{

	User getUser(Long userId);
	
	User save(User user);
	
	User authenticate(String email, String password);	
}