package com.revature.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Shift {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	private int startHour;
	
	@NotNull
	private int endHour;
	
	@ManyToMany
	private List<Employee> employees;

	
	
	public Shift() {
		super();
	}

	public Shift(int id, @NotNull int startHour, @NotNull int endHour, List<Employee> employees) {
		super();
		this.id = id;
		this.startHour = startHour;
		this.endHour = endHour;
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Shift [id=" + id + ", startHour=" + startHour + ", endHour=" + endHour + ", employees=" + employees
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employees == null) ? 0 : employees.hashCode());
		result = prime * result + endHour;
		result = prime * result + id;
		result = prime * result + startHour;
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
		Shift other = (Shift) obj;
		if (employees == null) {
			if (other.employees != null)
				return false;
		} else if (!employees.equals(other.employees))
			return false;
		if (endHour != other.endHour)
			return false;
		if (id != other.id)
			return false;
		if (startHour != other.startHour)
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStartHour() {
		return startHour;
	}

	public void setStartHour(int startHour) {
		this.startHour = startHour;
	}

	public int getEndHour() {
		return endHour;
	}

	public void setEndHour(int endHour) {
		this.endHour = endHour;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	
}
