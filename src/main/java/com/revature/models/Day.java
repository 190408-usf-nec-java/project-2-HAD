package com.revature.models;

import java.time.DayOfWeek;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Day {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	private DayOfWeek name;
	
	@NotNull
	private String date;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Shift> shifts;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public DayOfWeek getName() {
		return name;
	}

	public void setName(DayOfWeek name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Day other = (Day) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
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
		return "Day [id=" + id + ", name=" + name + ", date=" + date + ", shifts=" + shifts + "]";
	}

	public Day(int id, @NotNull DayOfWeek name, @NotNull String date, List<Shift> shifts) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.shifts = shifts;
	}
	public Day() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
