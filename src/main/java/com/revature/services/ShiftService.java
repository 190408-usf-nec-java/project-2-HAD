package com.revature.services;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Shift;
import com.revature.repositories.ShiftRepository;

@Service
public class ShiftService {
	
	@Autowired
	private ShiftRepository shiftRepository;
	
	@Inject
	public ShiftService(ShiftRepository sr) {
		this.shiftRepository = sr;
	}
	
	public void createShift(Shift shift) {
		shiftRepository.saveShift(shift);
	}
	
}
