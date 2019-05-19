package com.revature.repositories;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Shift;

@Repository
public class ShiftRepository {
	
SessionFactory sf;
	
	@Inject
	public ShiftRepository(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Transactional
	public void saveShift(Shift shift) {
		Session session = sf.getCurrentSession();
		session.save(shift);
	}
}
