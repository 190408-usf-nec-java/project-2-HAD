package com.revature.services;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.ShiftConfig;
import com.revature.models.Week;
import com.revature.repositories.ShiftConfigRepository;
import com.revature.repositories.WeekRepository;

@Service
public class WeekService {

	@Autowired
	private WeekRepository weekRepository;
	
	@Autowired
	private ShiftConfigRepository shiftConfRepo;
	
	@Inject
	public WeekService(WeekRepository wr, ShiftConfigRepository scr) {
		this.weekRepository = wr;
		this.shiftConfRepo = scr;
	}
	
	public void createWeek(Week week) {
		weekRepository.saveWeek(week);
	}
	
	public Week getWeekById(int userId) {
		if(weekRepository.getWeekById(userId) == null) {
			List <ShiftConfig> shiftConfig= shiftConfRepo.getShiftConfigurations(userId);
			Week week = ShiftConfigService.GenerateWeek(shiftConfig);
			return week;
		}else {
			return weekRepository.getWeekById(userId);
		}
	}
}
