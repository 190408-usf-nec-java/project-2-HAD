package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;
import com.revature.services.UserServices;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserServices userServices;
	
	public UserController(UserServices userServices) {
		this.userServices = userServices;
	}
	
	@PostMapping("")
	public void createUser(@RequestBody User user) {
		userServices.createUser(user);
	}
}
