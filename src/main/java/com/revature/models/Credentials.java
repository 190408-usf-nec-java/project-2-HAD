package com.revature.models;

import java.util.Arrays;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Credentials {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	@Column(name = "cred_id")
	private int id;
	@NotNull
	@Transient
	private char[] password;
	
	private String hashedPassword;
	
	@NotNull
	private String username;
	
	@Autowired
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "user_id")
	private Users user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public char[] getPassword() {
		return password;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}

	public String getHashedPassword() {
		return hashedPassword;
	}

	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hashedPassword == null) ? 0 : hashedPassword.hashCode());
		result = prime * result + id;
		result = prime * result + Arrays.hashCode(password);
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Credentials other = (Credentials) obj;
		if (hashedPassword == null) {
			if (other.hashedPassword != null)
				return false;
		} else if (!hashedPassword.equals(other.hashedPassword))
			return false;
		if (id != other.id)
			return false;
		if (!Arrays.equals(password, other.password))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Credentials [id=" + id + ", password=" + Arrays.toString(password) + ", hashedPassword="
				+ hashedPassword + ", username=" + username + ", user=" + user + "]";
	}

	public Credentials(int id, @NotNull char[] password, String hashedPassword, @NotNull String username, Users user) {
		super();
		this.id = id;
		this.password = password;
		this.hashedPassword = hashedPassword;
		this.username = username;
		this.user = user;
	}

	public Credentials() {
		super();
		// TODO Auto-generated constructor stub
	}

	
		
}
