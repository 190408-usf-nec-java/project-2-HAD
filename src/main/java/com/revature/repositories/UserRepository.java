package com.revature.repositories;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.models.User;
@Repository
public class UserRepository {

	SessionFactory sf; 
	
	@Inject
	public UserRepository(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Transactional
	public void saveUser(User user) {
		Session session = sf.getCurrentSession();
		session.save(user);
	}

	@Transactional
	public List<User> getAllUsers() {
		Session session = sf.getCurrentSession();
		return session.createCriteria(User.class).list();
	}

	@Transactional
	public User getUserById(int id) {
		Session session = sf.getCurrentSession();
		return session.get(User.class, id);
	}

	@Transactional
	public User deleteUserById(int id) {
		Session session = sf.getCurrentSession();
		User user = session.get(User.class, id);
		if (user == null) throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
		session.delete(user);
		return user;
	}

}
