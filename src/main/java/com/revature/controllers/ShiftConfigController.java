package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.ShiftConfig;
import com.revature.services.ShiftConfigService;

@RestController
@RequestMapping("config")
public class ShiftConfigController {
	
	@Autowired
	private ShiftConfigService shiftConfigService;
	
	public ShiftConfigController(ShiftConfigService shiftConfigService) {
		this.shiftConfigService = shiftConfigService;
	}
	@PostMapping("")
	public void createShiftConfig(@RequestBody ShiftConfig shiftConfig) {
		shiftConfigService.createConfig(shiftConfig);
	}
}
