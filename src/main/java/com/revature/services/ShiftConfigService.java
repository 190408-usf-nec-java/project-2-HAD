package com.revature.services;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

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
	
	@Inject
	public ShiftConfigService(ShiftConfigRepository shiftConfigRepository) {
		this.shiftConfigRepository = shiftConfigRepository;
	}
	public void createConfig(ShiftConfig shiftConfig) {
		this.shiftConfigRepository.saveConfig(shiftConfig);
	}
	
	public static Week GenerateWeek(List<ShiftConfig> configurations) {
		Map<DayOfWeek, Day> days = new LinkedHashMap<DayOfWeek, Day>();
		Week week = new Week();
		Day monday = new Day();
		monday.setName(DayOfWeek.MONDAY);
		monday.setShifts(new ArrayList<Shift>());
		monday.setDate("1/1/2019");
		Day tuesday = new Day();
		tuesday.setName(DayOfWeek.TUESDAY);
		tuesday.setShifts(new ArrayList<Shift>());
		tuesday.setDate("1/1/2019");
		Day wednesday = new Day();
		wednesday.setName(DayOfWeek.WEDNESDAY);
		wednesday.setShifts(new ArrayList<Shift>());
		wednesday.setDate("1/1/2019");
		Day thursday = new Day();
		thursday.setName(DayOfWeek.THURSDAY);
		thursday.setShifts(new ArrayList<Shift>());
		thursday.setDate("1/1/2019");
		Day friday = new Day();
		friday.setName(DayOfWeek.FRIDAY);
		friday.setShifts(new ArrayList<Shift>());
		friday.setDate("1/1/2019");
		Day saturday = new Day();
		saturday.setName(DayOfWeek.SATURDAY);
		saturday.setShifts(new ArrayList<Shift>());
		saturday.setDate("1/1/2019");
		Day sunday = new Day();
		sunday.setName(DayOfWeek.SUNDAY);
		sunday.setShifts(new ArrayList<Shift>());
		sunday.setDate("1/1/2019");
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
		days.put(monday.getName(), monday);
		days.put(tuesday.getName(), tuesday);
		days.put(wednesday.getName(), wednesday);
		days.put(thursday.getName(), thursday);
		days.put(friday.getName(), friday);
		days.put(saturday.getName(), saturday);
		days.put(sunday.getName(), sunday);
		week.setDays(days);
		return week;
	}

}
