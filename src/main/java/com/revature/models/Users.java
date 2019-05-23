 package com.revature.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;

@Entity(name = "people")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int id;
	
	@NotNull
	@OneToOne
	@JoinColumn(name = "cred_id")
	@Autowired
	private Credentials credentials;
	
	@NotNull
	private String firstName;
	
	@NotNull
	private String lastName;
	
	@NotNull
	private String email;
	
	@NotNull
	private int role;
	
	@OneToMany
	@JoinColumn(name = "user_id")
	private List<ShiftConfig> shiftConfigs;

	@ManyToOne
	@JoinColumn(name = "role_Name")
	private Role roles;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Credentials getCredentials() {
		return credentials;
	}

	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public List<ShiftConfig> getShiftConfigs() {
		return shiftConfigs;
	}

	public void setShiftConfigs(List<ShiftConfig> shiftConfigs) {
		this.shiftConfigs = shiftConfigs;
	}

	public Role getRoles() {
		return roles;
	}

	public void setRoles(Role roles) {
		this.roles = roles;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((credentials == null) ? 0 : credentials.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + role;
		result = prime * result + ((roles == null) ? 0 : roles.hashCode());
		result = prime * result + ((shiftConfigs == null) ? 0 : shiftConfigs.hashCode());
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
		Users other = (Users) obj;
		if (credentials == null) {
			if (other.credentials != null)
				return false;
		} else if (!credentials.equals(other.credentials))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (role != other.role)
			return false;
		if (roles == null) {
			if (other.roles != null)
				return false;
		} else if (!roles.equals(other.roles))
			return false;
		if (shiftConfigs == null) {
			if (other.shiftConfigs != null)
				return false;
		} else if (!shiftConfigs.equals(other.shiftConfigs))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", credentials=" + credentials + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", role=" + role + ", shiftConfigs=" + shiftConfigs + ", roles="
				+ roles + "]";
	}

	public Users(int id, @NotNull Credentials credentials, @NotNull String firstName, @NotNull String lastName,
			@NotNull String email, @NotNull int role, List<ShiftConfig> shiftConfigs, Role roles) {
		super();
		this.id = id;
		this.credentials = credentials;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
		this.shiftConfigs = shiftConfigs;
		this.roles = roles;
	}

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
