package com.revature.services;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.User;
import com.revature.repositories.UserRepository;
@Service
public class UserServices {

	@Autowired
	private UserRepository userRepository;
	
	@Inject 
	public UserServices(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	public void createUser(User user) {
		userRepository.saveUser(user);
	}
	public List<User> getAllUsers() {
		return userRepository.getAllUsers();
	}
	public User getUserById(int id) {
		return userRepository.getUserById(id);
	}
	public User deleteUserById(int id) {
		return userRepository.deleteUserById(id);
	}

}
