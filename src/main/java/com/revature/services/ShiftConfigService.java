package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.ShiftConfig;
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

}
