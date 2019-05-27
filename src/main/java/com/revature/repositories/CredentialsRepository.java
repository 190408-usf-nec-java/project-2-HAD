package com.revature.repositories;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Repository;

import com.revature.models.Credentials;
import com.revature.models.Users;

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

	public Users createCredentials(Credentials credentials) {
		Session session = sf.getCurrentSession();
		session.save(credentials.getUser());
		session.save(credentials);
		return credentials.getUser();
	}

	@SuppressWarnings("unchecked")
	public List<Credentials> getAllCredentials() {
		String hql = "FROM Credentials c";
		Session session = sf.getCurrentSession();
		List<Credentials> cred = session.createQuery(hql).getResultList();
		return cred;
	}
	
}
