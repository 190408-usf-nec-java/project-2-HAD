package com.revature.repositories;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.type.StringType;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;

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
				.setParameter("user", credentials.getUsername(), StringType.INSTANCE).uniqueResult();
		return credentials;
	}

	public void createLogin(Credentials cred) {
		Session session = sf.getCurrentSession();
		session.save(cred.getUser());
		session.save(cred);
	}

	public Users createCredentials(Credentials credentials) {
		try {
			Session session = sf.getCurrentSession();
			session.save(credentials.getUser());
			session.save(credentials);
			return credentials.getUser();
		} catch (DataIntegrityViolationException e) {
			throw new HttpClientErrorException(HttpStatus.FORBIDDEN);
		}
	}

	public boolean isUnique(Credentials credentials) {
		String hql = "FROM Credentials c WHERE username = :user";
		Session session = sf.getCurrentSession();
		credentials = session.createQuery(hql, Credentials.class)
				.setParameter("user", credentials.getUsername(), StringType.INSTANCE).uniqueResult();
		return credentials == null;
	}

}
