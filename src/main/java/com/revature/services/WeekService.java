package com.revature.services;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Week;
import com.revature.repositories.WeekRepository;

@Service
public class WeekService {

	@Autowired
	private WeekRepository weekRepository;
	
	@Inject
	public WeekService(WeekRepository wr) {
		this.weekRepository = wr;
	}
	
	public void createWeek(Week week) {
		weekRepository.saveWeek(week);
	}
	
	public Week getWeekById(int id) {
		return weekRepository.getWeekById(id);
	}
}
