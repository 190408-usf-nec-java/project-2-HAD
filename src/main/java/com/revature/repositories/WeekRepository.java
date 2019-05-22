package com.revature.repositories;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Week;

@Repository
public class WeekRepository {

	SessionFactory sf;
	
	@Inject
	public WeekRepository(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Transactional
	public void saveWeek(Week week) {
		Session session = sf.getCurrentSession();
		session.save(week);
	}
	
	@Transactional
	public Week getWeekById(int id) {
		Session session = sf.getCurrentSession();
		return session.get(Week.class, id);
	}
}
