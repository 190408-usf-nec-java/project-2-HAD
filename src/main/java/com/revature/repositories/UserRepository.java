package com.revature.repositories;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;


import com.revature.models.User;
@Repository
public class UserRepository {

	SessionFactory sf; 
	
	@Inject
	public UserRepository(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Transactional
	public void saveUser(User user) {
		Session session = sf.getCurrentSession();
		session.save(user);
	}

}
