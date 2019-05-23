package com.revature.services;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Role;
import com.revature.repositories.RoleRepository;
@Service
public class RoleService {
@Autowired
private RoleRepository roleRepository;


@Inject
public RoleService(RoleRepository roleRepository) {
	this.roleRepository = roleRepository;
}

	public void createRole(Role role) {
		roleRepository.createRole(role);
		
	}

	public Role deleteRoleById(int role) {
		return this.roleRepository.deleteRoleById(role);
	}

	public Object getRoleById(int role) {
		return this.roleRepository.getRoleById(role);
	}

}
