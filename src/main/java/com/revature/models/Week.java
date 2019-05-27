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

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Week {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Day firstDay;
	
	@Autowired
	@OneToMany(cascade = CascadeType.ALL)
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

	
	public Day getFirstDay() {
		return firstDay;
	}

	public void setFirstDay(Day firstDay) {
		this.firstDay = firstDay;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((days == null) ? 0 : days.hashCode());
		result = prime * result + ((firstDay == null) ? 0 : firstDay.hashCode());
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
		if (firstDay == null) {
			if (other.firstDay != null)
				return false;
		} else if (!firstDay.equals(other.firstDay))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Week [id=" + id + ", firstDay=" + firstDay + ", days=" + days + "]";
	}

	public Week(int id, Day firstDay, Map<DayOfWeek, Day> days) {
		super();
		this.id = id;
		this.firstDay = firstDay;
		this.days = days;
	}

	public Week() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
