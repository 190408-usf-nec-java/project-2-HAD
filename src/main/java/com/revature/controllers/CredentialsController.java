package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Credentials;
import com.revature.models.Users;
import com.revature.services.CredentialsService;

@RestController
@RequestMapping("cred")
public class CredentialsController {
	
	private CredentialsService credentialsService;

	@Autowired
	public CredentialsController(CredentialsService credentialsService) {
		super();
		this.credentialsService = credentialsService;
	}
	
	@PostMapping("login")
	public Users login(@RequestBody Credentials credentials) {
		Users user = credentialsService.login(credentials);
		return user;
	}
}
