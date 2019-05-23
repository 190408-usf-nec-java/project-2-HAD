package com.revature.repositories;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.models.Role;

@Repository
public class RoleRepository {

	SessionFactory sf;
	
	
	

	public RoleRepository(SessionFactory sf) {
		this.sf = sf;
	}

	@Transactional
	public void createRole(Role role) {
		Session session = sf.getCurrentSession();
		session.save(role);
	}

	@Transactional
	public Role deleteRoleById(int role) {
		Session session = sf.getCurrentSession();
		Role roles = session.get(Role.class, role);
		if(roles == null) throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
		session.delete(roles);
		return roles;
	}

	@Transactional
	public Object getRoleById(int role) {
		Session session = sf.getCurrentSession();
		return session.get(Role.class, role);
	}

}
