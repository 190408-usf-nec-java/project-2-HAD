package com.revature.services;

import java.security.MessageDigest;
import java.security.SecureRandom;

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
		if (checkCred.getHashedPassword().equals(credentials.getHashedPassword())) {
			return checkCred.getUser();
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
			System.out.println("Hashed Pass");
			credentials.setHashedPassword(sb2.toString());
			System.out.println(credentials);
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

	public String getToken() {
		StringBuilder sb = new StringBuilder();
		try {
			MessageDigest SHA256 = MessageDigest.getInstance("SHA-256");
			byte[] bytes = new byte[20];
			SecureRandom.getInstanceStrong().nextBytes(bytes);
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}

		} catch (Exception e) {

		}
		return sb.toString();
	}

}
