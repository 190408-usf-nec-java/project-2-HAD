package com.revature.repositories;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.models.Users;
@Repository
public class UserRepository {

	SessionFactory sf; 
	
	@Inject
	public UserRepository(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Transactional
	public void saveUser(Users user) {
		Session session = sf.getCurrentSession();
		session.save(user);
	}

	@Transactional
	public List<Users> getAllUsers() {
		Session session = sf.getCurrentSession();
		return session.createCriteria(Users.class).list();
	}

	@Transactional
	public Users getUserById(int id) {
		Session session = sf.getCurrentSession();
		return session.get(Users.class, id);
	}

	@Transactional
	public Users deleteUserById(int id) {
		Session session = sf.getCurrentSession();
		Users user = session.get(Users.class, id);
		if (user == null) throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
		session.delete(user);
		return user;
	}

}
