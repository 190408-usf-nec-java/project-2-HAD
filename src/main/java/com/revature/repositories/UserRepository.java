package com.revature.repositories;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.models.Credentials;
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
	public void deleteUserById(int id) {
		String hql = "FROM Credentials c WHERE user_id = :user";
		Session session = sf.getCurrentSession();
		Credentials credentials = session.createQuery(hql, Credentials.class)
							.setParameter("user", id, IntegerType.INSTANCE)
							.uniqueResult();
		credentials.setPassword(new char[1]);
		session.delete(credentials.getUser());
		session.delete(credentials);
	}

}
