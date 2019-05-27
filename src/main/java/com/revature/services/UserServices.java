package com.revature.services;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Users;
import com.revature.repositories.UserRepository;
@Service
public class UserServices {

	@Autowired
	private UserRepository userRepository;
	
	@Inject 
	public UserServices(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	public void createUser(Users user) {
		userRepository.saveUser(user);
	}
	public List<Users> getAllUsers() {
		return userRepository.getAllUsers();
	}
	public Users getUserById(int id) {
		return userRepository.getUserById(id);
	}
	public void deleteUserById(int id) {
		userRepository.deleteUserById(id);
	}

}
