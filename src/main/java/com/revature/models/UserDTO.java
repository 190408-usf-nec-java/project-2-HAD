package com.revature.models;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDTO {
	List<Credentials> employees;

	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDTO(List<Credentials> employees) {
		super();
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "UserDTO [employees=" + employees + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employees == null) ? 0 : employees.hashCode());
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
		UserDTO other = (UserDTO) obj;
		if (employees == null) {
			if (other.employees != null)
				return false;
		} else if (!employees.equals(other.employees))
			return false;
		return true;
	}

	public List<Credentials> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Credentials> employees) {
		this.employees = employees;
	}
	
	
}
