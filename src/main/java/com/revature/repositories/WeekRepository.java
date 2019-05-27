package com.revature.repositories;

import java.time.DayOfWeek;
import java.util.Map;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Day;
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
		session.saveOrUpdate(week);
	}
	
	@Transactional
	public Week getWeekById(int id) {
		Session session = sf.getCurrentSession();
		return session.get(Week.class, id);
	}
	@Transactional
	public void updateWeek(Week week) {
		Session session = sf.getCurrentSession();
		week.getDays().forEach((DayOfWeek, Day) -> {
			Day.getShifts().forEach((shift)-> {
				session.save(shift);
			});
		});
		session.merge(week);
		//System.out.println(week);
		
	}
}
