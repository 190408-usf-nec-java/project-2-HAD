package com.revature.controllers;

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

import com.revature.models.Role;
import com.revature.services.RoleService;

@RestController
@RequestMapping("roles")
public class RoleController {
	
	@Autowired
	private RoleService roleService;

	public RoleController(RoleService roleService) {
		this.roleService = roleService;
	}
	
	@PostMapping("/{role}")
	public void createRole(@RequestBody Role role) {
		roleService.createRole(role);
	}
	
	@DeleteMapping("/{role}")
	public void deleteRoleById(@PathVariable int role) {
		System.out.println(roleService.deleteRoleById(role));
	}
	
	@GetMapping("/{role}")
	public Role getRoleById(@PathVariable int role) {
		return (Role) Optional.ofNullable(this.roleService.getRoleById(role))
				.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}

}
