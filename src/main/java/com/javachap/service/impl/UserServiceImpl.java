package com.javachap.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.javachap.domain.User;
import com.javachap.service.UserService;
import com.javachap.utils.HibernateUtils;

public class UserServiceImpl extends ServiceImpl implements UserService {

	private static final long serialVersionUID = 4889152297004460837L;

	private String AUTHENTICATION_QUERY = 
		"from User user where user.email= :Email and user.password = :Password";
	
	/**
	 * Singleton Instance of UserServiceImpl
	 */
	private static UserServiceImpl userServiceImpl = new UserServiceImpl();
	
	/**
	 * Creates Instance of {@link UserServiceImpl}
	 */
	private UserServiceImpl(){		
	}
	
	/***
	 * Gets Instance of UserService
	 * @return UserService Implementation
	 */
	public static UserService getInstance(){	
		return userServiceImpl;
	}

	public User authenticate(String email, String password) {
		User user = null;
		try {
			Session session = HibernateUtils.currentSession();
			Query query = session.createQuery(AUTHENTICATION_QUERY);
			query.setString("Email", email);
			query.setString("Password", password);
			@SuppressWarnings("unchecked")
			List<User> list = (List<User>) query.list();
			if (list.size() == 1) {
				user = (User) list.get(0);
			}
			HibernateUtils.closeSession();
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		return user;
	}

	public User getUser(Long userId) {
		User user = null;
		try {
			Session session = HibernateUtils.currentSession();
			user = (User)session.get(User.class, userId);
			HibernateUtils.closeSession();
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		return user;
	}

	public User save(User user) {
		
		Session session = HibernateUtils.currentSession();
		Transaction tx = null;
		boolean rollback = true;
		try {
		     tx = session.beginTransaction();
		     session.save(user);
		     tx.commit();
		     rollback = false;
		 }
		 catch (Exception e) {
		     throw new ServiceException(e);
		 }
		 finally {
			 if( rollback && tx != null){ 
		    	 tx.rollback();
			 }			 
			 HibernateUtils.closeSession();
		 }
		return user;		
	}
}
