package com.revature.repositories;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
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
		String hql = "SELECT count(*) FROM people";
		Session session = sf.getCurrentSession();
		long numEmployees = (long)session.createQuery(hql).iterate().next();
		shiftConfig.setNumberOfEmployees(numEmployees);
		session.update(shiftConfig.getUsers());
		session.save(shiftConfig.getWeekdays());
		session.save(shiftConfig);
	}

	public List<ShiftConfig> getShiftConfigurations(int userId) {
		Session session = sf.getCurrentSession();
		String hql = "FROM ShiftConfig WHERE userId like :userId";
		List<ShiftConfig> results = session.createQuery(hql, ShiftConfig.class)
				.setParameter(1, userId, IntegerType.INSTANCE)
				.list();
		return results;
	}
	
}
