package com.revature.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.models.Users;
import com.revature.services.UserServices;

@RestController
@RequestMapping("people")
public class UserController {

	@Autowired
	private UserServices userServices;
	
	public UserController(UserServices userServices) {
		this.userServices = userServices;
	}
	
	@PostMapping("")
	public void createUser(@RequestBody Users user) {
		userServices.createUser(user);
	}
	
	@GetMapping("")
	public List<Users> getAllUsers() {
		return userServices.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public Users getUserById(@PathVariable int id) {
		return Optional.ofNullable(this.userServices.getUserById(id))
				.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}
	
	@DeleteMapping("/{id}")
	public void deleteUserById(@PathVariable int id) {
		userServices.deleteUserById(id);
	}
}

























