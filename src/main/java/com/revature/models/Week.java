package com.revature.models;

import java.time.DayOfWeek;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Week {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private Day firstDay;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	private Map<DayOfWeek, Day> days;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Map<DayOfWeek, Day> getDays() {
		return days;
	}

	public void setDays(Map<DayOfWeek, Day> days) {
		this.days = days;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((days == null) ? 0 : days.hashCode());
		result = prime * result + id;
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
		Week other = (Week) obj;
		if (days == null) {
			if (other.days != null)
				return false;
		} else if (!days.equals(other.days))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Week [id=" + id + ", days=" + days + "]";
	}

	public Week(int id, Map<DayOfWeek, Day> days) {
		super();
		this.id = id;
		this.days = days;
	}

	public Week() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
