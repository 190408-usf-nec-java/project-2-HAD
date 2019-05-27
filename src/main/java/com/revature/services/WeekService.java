package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.ShiftConfig;
import com.revature.models.Week;
import com.revature.models.WeekDays;
import com.revature.repositories.ShiftConfigRepository;
import com.revature.repositories.UserRepository;
import com.revature.repositories.WeekRepository;

@Service
public class WeekService {

	@Autowired
	private WeekRepository weekRepository;
	
	@Autowired
	private ShiftConfigRepository shiftConfRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Inject
	public WeekService(WeekRepository wr, ShiftConfigRepository scr, UserRepository usr) {
		this.weekRepository = wr;
		this.shiftConfRepo = scr;
		this.userRepo = usr;
	}
	
	public Week createWeek() {
		WeekDays weekDays = new WeekDays(1, true, true, true, true, true, false, false);
		ShiftConfig shift1 = new ShiftConfig(1, 2, 8, weekDays, 2, userRepo.getUserById(2));
		WeekDays weekDays2 = new WeekDays(2, false, false, false, false, false, true, true);
		ShiftConfig shift2 = new ShiftConfig(2, 6, 16, weekDays2, 3, userRepo.getUserById(2));
		List<ShiftConfig> shiftConfig = new ArrayList<ShiftConfig>();
		shiftConfig.add(shift1);
		shiftConfig.add(shift2);
		Week week = ShiftConfigService.GenerateWeek(shiftConfig);
		weekRepository.saveWeek(week);
		return week;
	}
	public Week getWeekById(int id) {
		if(weekRepository.getWeekById(id) == null) {
			System.out.println("No week stored");
			//List <ShiftConfig> shiftConfig = shiftConfRepo.getShiftConfigurations(userId);
			Week week = createWeek();
			return week;
		}else {
			Week week = weekRepository.getWeekById(id);
			System.out.println(week);
			return weekRepository.getWeekById(id);
		}
	}

	public void updateWeek(Week week) {
		weekRepository.updateWeek(week);
		
	}
}
