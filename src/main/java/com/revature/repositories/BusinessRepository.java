package com.revature.repositories;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.revature.models.Business;

@Repository
public class BusinessRepository {

	SessionFactory sf; 
	
	@Inject
	public BusinessRepository(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Transactional
	public void saveBusiness(Business business) {
		Session session = sf.getCurrentSession();
		session.save(business);
	}

}
