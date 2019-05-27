package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.models.Credentials;
import com.revature.models.UserDTO;
import com.revature.models.Users;
import com.revature.services.CredentialsService;

@RestController
@RequestMapping("cred")
public class CredentialsController {
	
	private CredentialsService credentialsService;
	private UserDTO dto;

	@Autowired
	public CredentialsController(CredentialsService credentialsService, UserDTO dto) {
		super();
		this.credentialsService = credentialsService;
		this.dto = dto;
	}
	
	@PostMapping("login")
	public Users login(@RequestBody Credentials credentials) {
		Users user = credentialsService.login(credentials);
		return user;
	}
	
	@GetMapping("add")
	public String add() {
		Users user = new Users(1, "Monty", "Python", "monty@python.org", 2, null, null);
		Credentials cred = new Credentials(1, "hamsterparty".toCharArray(), null ,"MontyPython", user);
		cred = CredentialsService.hashPassword(cred);
		credentialsService.addCredentials(cred);
		return "added user";
		// adding a comment to test github
	}
	@GetMapping("")
	public List<Credentials> getAllCredentials() {
		return credentialsService.getAllCredentials();
	}
	
	@PostMapping("create")
	public Users createCredentials(@RequestBody Credentials credentials) {
		if (!credentialsService.isUnique(credentials)) {
			throw new HttpClientErrorException(HttpStatus.FORBIDDEN);
		}
		credentials = CredentialsService.hashPassword(credentials);		
		Users user = credentialsService.createCredentials(credentials);
		return user;
	}
	
	@ExceptionHandler(HttpClientErrorException.class)
	public ResponseEntity<String> handleClientError(HttpClientErrorException e) {
		return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
	}
}
