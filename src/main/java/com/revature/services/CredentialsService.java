package com.revature.services;

import java.security.MessageDigest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.models.Credentials;
import com.revature.models.Users;
import com.revature.repositories.CredentialsRepository;
import com.revature.repositories.UserRepository;

@Service
public class CredentialsService {

	private CredentialsRepository credRepo;
	private UserRepository userRepository;

	@Autowired
	public CredentialsService(CredentialsRepository credRepo, UserRepository userRepository) {
		super();
		this.credRepo = credRepo;
		this.userRepository = userRepository;
	}

	public Users login(Credentials credentials) throws HttpClientErrorException {
		Credentials checkCred = credRepo.getLogin(credentials);
		if (checkCred == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
		}

		credentials = CredentialsService.hashPassword(credentials);
		System.out.println(credentials);
		if (checkCred.getHashedPassword().contentEquals(credentials.getHashedPassword())) {
			return credentials.getUser();
		} else {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
		}
	}

	public static Credentials hashPassword(Credentials credentials) {
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		char[] chars = credentials.getPassword();
		sb.append(chars);
		try {
			MessageDigest SHA256 = MessageDigest.getInstance("SHA-256");
			byte[] bytes = SHA256.digest(sb.toString().getBytes());

			for (int i = 0; i < bytes.length; i++) {
				sb2.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			credentials.setHashedPassword(sb2.toString());
		} catch (Exception e) {

		}
		return credentials;
	}

	public void addCredentials(Credentials cred) {
		credRepo.createLogin(cred);

	}

	public Users createCredentials(Credentials credentials) {
		return credRepo.createCredentials(credentials);
	}

}
