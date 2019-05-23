package com.revature.services;

import java.security.MessageDigest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.models.Credentials;
import com.revature.models.Users;
import com.revature.repositories.UserRepository;
import com.revature.repository.CredentialsRepository;

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
	
	public Users login(Credentials credentials) {
		Credentials checkCred = credRepo.getLogin(credentials);
		if(credentials == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
		}
		credentials = CredentialsService.hashPassword(credentials);
		if(checkCred.getHashedPassword().contentEquals(credentials.getHashedPassword())) {
			return credentials.getUser();
		}else {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
		}
	}

	private static Credentials hashPassword(Credentials credentials) {
		StringBuilder sb = new StringBuilder();
		char[] chars = credentials.getPassword();
		sb.append(chars);
		try {
            MessageDigest SHA256 = MessageDigest.getInstance("SHA-256");
            byte[] bytes = SHA256.digest(sb.toString().getBytes());
            
            for(int i=0; i< bytes.length; i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            credentials.setHashedPassword(sb.toString());
		} catch(Exception e) {
			
		}
		return credentials;
	}
}
