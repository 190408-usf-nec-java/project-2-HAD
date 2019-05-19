package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Shift;
import com.revature.services.ShiftService;

@RestController
@RequestMapping("shift")
public class ShiftController {
	
	@Autowired
	private ShiftService shiftService;
	
	public ShiftController(ShiftService shiftService) {
		this.shiftService = shiftService;
	}
	@PostMapping("")
	public void createShift(@RequestBody Shift shift) {
		System.out.println(shift);
		shiftService.createShift(shift);
	}
}
