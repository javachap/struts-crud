package com.javachap.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.javachap.domain.Lead;
import com.javachap.domain.User;
import com.javachap.service.LeadService;
import com.javachap.utils.HibernateUtils;

/**
 * @author Varma
 */

public class LeadServiceImpl extends ServiceImpl implements LeadService {

	private static final long serialVersionUID = 872905902784301462L;

	private static final String LEADS_BY_USER_QUERY = 
			"from Lead lead where lead.owner.id = :UserId";
	
	/**
	 * Singleton Instance of LeadServiceImpl
	 */
	private static LeadServiceImpl leadServiceImpl = new LeadServiceImpl();
	
	/**
	 * Creates Instance of {@link LeadServiceImpl}
	 */
	private LeadServiceImpl(){		
	}
	
	/***
	 * Gets Instance of LeadService
	 * @return LeadService Implementation
	 */
	public static LeadServiceImpl getInstance(){	
		return leadServiceImpl;
	}
	
	/* (non-Javadoc)
	 * @see com.javachap.service.LeadService#delete(com.javachap.domain.Lead)
	 */
	public void delete(Lead lead) {
		Session session = HibernateUtils.currentSession();
		Transaction tx = null;
		boolean rollback = true;
		try {
		     tx = session.beginTransaction();
		     session.delete(lead);
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
	}

	/* (non-Javadoc)
	 * @see com.javachap.service.LeadService#getLead(java.lang.Long)
	 */
	public Lead getLead(Long id) {
		Lead lead = null;
		try {
			Session session = HibernateUtils.currentSession();
			lead = (Lead)session.get(Lead.class, id);
			HibernateUtils.closeSession();
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		return lead;	
	}

	/* (non-Javadoc)
	 * @see com.javachap.service.LeadService#save(com.javachap.domain.Lead)
	 */
	public Lead save(Lead lead) {
		Session session = HibernateUtils.currentSession();
		Transaction tx = null;
		boolean rollback = true;
		try {
		     tx = session.beginTransaction();
		     session.saveOrUpdate(lead);
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
		return lead;
	}
	
	/* (non-Javadoc)
	 * @see com.javachap.service.LeadService#getLeadsByUser(com.javachap.domain.User)
	 */
	@SuppressWarnings("unchecked")
	public List<Lead> getLeadsByUser(User user) {
		List<Lead> leads = null; 
		try {
			Session session = HibernateUtils.currentSession();
			Query query = session.createQuery(LEADS_BY_USER_QUERY);
			query.setParameter("UserId", user.getId());
			leads = (List<Lead>) query.list();
			HibernateUtils.closeSession();
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		return leads;	}	
}
