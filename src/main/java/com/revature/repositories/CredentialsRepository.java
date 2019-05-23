package com.revature.repositories;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Repository;

import com.revature.models.Credentials;

@Repository
public class CredentialsRepository {

	SessionFactory sf;
	
	@Inject
	public CredentialsRepository(SessionFactory sf) {
		this.sf = sf;
	}
	
	public Credentials getLogin(Credentials credentials) {
		String hql = "FROM Credentials c WHERE username = :user";
		Session session = sf.getCurrentSession();
		credentials = session.createQuery(hql, Credentials.class)
							.setParameter("user", credentials.getUsername(), StringType.INSTANCE)
							.uniqueResult();
		return credentials;
	}

	public void createLogin(Credentials cred) {
		Session session = sf.getCurrentSession();
		session.save(cred.getUser());
		session.save(cred);
	}
	
}
