package com.revature.repositories;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.ShiftConfig;

@Repository
public class ShiftConfigRepository {

	
	SessionFactory sf;
	
	@Inject
	public ShiftConfigRepository(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Transactional
	public void saveConfig(ShiftConfig shiftConfig) {
		Session session = sf.getCurrentSession();
		session.save(shiftConfig);
	}
	
}
