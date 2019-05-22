package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Day;
import com.revature.models.Shift;
import com.revature.models.ShiftConfig;
import com.revature.models.Week;
import com.revature.models.WeekDays;
import com.revature.repositories.ShiftConfigRepository;

@Service
public class ShiftConfigService {
	
	@Autowired
	private ShiftConfigRepository shiftConfigRepository;
	
	public ShiftConfigService(ShiftConfigRepository shiftConfigRepository) {
		this.shiftConfigRepository = shiftConfigRepository;
	}
	public void createConfig(ShiftConfig shiftConfig) {
		this.shiftConfigRepository.saveConfig(shiftConfig);
	}
	
	public static Week GenerateWeek(List<ShiftConfig> configurations) {
		Week week = new Week();
		Day monday = new Day();
		monday.setName("Monday");
		monday.setShifts(new ArrayList<Shift>());
		Day tuesday = new Day();
		tuesday.setName("Tuesday");
		tuesday.setShifts(new ArrayList<Shift>());
		Day wednesday = new Day();
		wednesday.setName("Wednesday");
		wednesday.setShifts(new ArrayList<Shift>());
		Day thursday = new Day();
		thursday.setName("Thursday");
		thursday.setShifts(new ArrayList<Shift>());
		Day friday = new Day();
		friday.setName("Friday");
		friday.setShifts(new ArrayList<Shift>());
		Day saturday = new Day();
		saturday.setName("Saturday");
		saturday.setShifts(new ArrayList<Shift>());
		Day sunday = new Day();
		sunday.setName("Sunday");
		sunday.setShifts(new ArrayList<Shift>());
		configurations.forEach(config -> {
			Shift shift = new Shift();
			shift.setStartHour(config.getStartTime());
			shift.setEndHour(config.getEndTime());
			WeekDays weekDays = config.getWeekdays();
			if(weekDays.isMonday()) {
				List<Shift> shifts = monday.getShifts();
				shifts.add(shift);
			}
			if(weekDays.isTuesday()) {
				List<Shift> shifts = tuesday.getShifts();
				shifts.add(shift);
			}
			if(weekDays.isWednesday()) {
				List<Shift> shifts = wednesday.getShifts();
				shifts.add(shift);
			}
			if(weekDays.isThursday()) {
				List<Shift> shifts = thursday.getShifts();
				shifts.add(shift);
			}
			if(weekDays.isFriday()) {
				List<Shift> shifts = friday.getShifts();
				shifts.add(shift);
			}
			if(weekDays.isSaturday()) {
				List<Shift> shifts = saturday.getShifts();
				shifts.add(shift);
			}
			if(weekDays.isSunday()) {
				List<Shift> shifts = sunday.getShifts();
				shifts.add(shift);
			}
		});
		List<Day> days = new ArrayList<Day>();
		days.add(monday);
		days.add(tuesday);
		days.add(wednesday);
		days.add(thursday);
		days.add(friday);
		days.add(saturday);
		days.add(sunday);
		week.setDays(days);
		return week;
	}

}
