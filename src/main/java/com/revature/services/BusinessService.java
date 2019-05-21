package com.revature.services;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Business;
import com.revature.repositories.BusinessRepository;

@Service
public class BusinessService {

	@Autowired
	private BusinessRepository businessRepository;

	@Inject
	public BusinessService(BusinessRepository businessRepository) {
		this.businessRepository = businessRepository;
	}
	
	public void createBusiness(Business business) {
		businessRepository.saveBusiness(business);
	}
	
	
}
