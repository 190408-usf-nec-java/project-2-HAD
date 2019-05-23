package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity(name="role")
public class Role {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name ="role_id")
private int id;

@NotNull
private String name;

@NotNull
@OneToMany
@JoinColumn(name = "role_Name")
private Users users;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public Users getUsers() {
	return users;
}

public void setUsers(Users users) {
	this.users = users;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + id;
	result = prime * result + ((users == null) ? 0 : users.hashCode());
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
	Role other = (Role) obj;
	if (id != other.id)
		return false;
	if (users == null) {
		if (other.users != null)
			return false;
	} else if (!users.equals(other.users))
		return false;
	return true;
}

@Override
public String toString() {
	return "Role [id=" + id + ", users=" + users + "]";
}

public Role(int id, @NotNull Users users) {
	super();
	this.id = id;
	this.users = users;
}

public Role() {
	super();
	// TODO Auto-generated constructor stub
}



}
