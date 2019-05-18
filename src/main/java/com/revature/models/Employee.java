package com.revature.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToMany
	private List<Shift> shifts;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Shift> getShifts() {
		return shifts;
	}

	public void setShifts(List<Shift> shifts) {
		this.shifts = shifts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((shifts == null) ? 0 : shifts.hashCode());
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
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		if (shifts == null) {
			if (other.shifts != null)
				return false;
		} else if (!shifts.equals(other.shifts))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", shifts=" + shifts + "]";
	}

	public Employee(int id, List<Shift> shifts) {
		super();
		this.id = id;
		this.shifts = shifts;
	}

	public Employee() {
		super();
	}
	
	
}
