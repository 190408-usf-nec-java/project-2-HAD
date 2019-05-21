package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Business;
import com.revature.services.BusinessService;

@RestController
@RequestMapping("business")
public class BusinessController {
	
@Autowired
private BusinessService businessServices;

public BusinessController(BusinessService businessServices) {
	this.businessServices = businessServices;
}

@PostMapping("")
public void createBusiness(@RequestBody Business business) {
	businessServices.createBusiness(business);
}

}
