package com.revature.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class WeekDays {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private boolean monday;
	private boolean tuesday;
	private boolean wednesday;
	private boolean thursday;
	private boolean friday;
	private boolean saturday;
	private boolean sunday;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isMonday() {
		return monday;
	}
	public void setMonday(boolean monday) {
		this.monday = monday;
	}
	public boolean isTuesday() {
		return tuesday;
	}
	public void setTuesday(boolean tuesday) {
		this.tuesday = tuesday;
	}
	public boolean isWednesday() {
		return wednesday;
	}
	public void setWednesday(boolean wednesday) {
		this.wednesday = wednesday;
	}
	public boolean isThursday() {
		return thursday;
	}
	public void setThursday(boolean thursday) {
		this.thursday = thursday;
	}
	public boolean isFriday() {
		return friday;
	}
	public void setFriday(boolean friday) {
		this.friday = friday;
	}
	public boolean isSaturday() {
		return saturday;
	}
	public void setSaturday(boolean saturday) {
		this.saturday = saturday;
	}
	public boolean isSunday() {
		return sunday;
	}
	public void setSunday(boolean sunday) {
		this.sunday = sunday;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (friday ? 1231 : 1237);
		result = prime * result + id;
		result = prime * result + (monday ? 1231 : 1237);
		result = prime * result + (saturday ? 1231 : 1237);
		result = prime * result + (sunday ? 1231 : 1237);
		result = prime * result + (thursday ? 1231 : 1237);
		result = prime * result + (tuesday ? 1231 : 1237);
		result = prime * result + (wednesday ? 1231 : 1237);
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
		WeekDays other = (WeekDays) obj;
		if (friday != other.friday)
			return false;
		if (id != other.id)
			return false;
		if (monday != other.monday)
			return false;
		if (saturday != other.saturday)
			return false;
		if (sunday != other.sunday)
			return false;
		if (thursday != other.thursday)
			return false;
		if (tuesday != other.tuesday)
			return false;
		if (wednesday != other.wednesday)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "WeekDays [id=" + id + ", monday=" + monday + ", tuesday=" + tuesday + ", wednesday=" + wednesday
				+ ", thursday=" + thursday + ", friday=" + friday + ", saturday=" + saturday + ", sunday=" + sunday
				+ "]";
	}
	public WeekDays(int id, boolean monday, boolean tuesday, boolean wednesday, boolean thursday, boolean friday,
			boolean saturday, boolean sunday) {
		super();
		this.id = id;
		this.monday = monday;
		this.tuesday = tuesday;
		this.wednesday = wednesday;
		this.thursday = thursday;
		this.friday = friday;
		this.saturday = saturday;
		this.sunday = sunday;
	}
	public WeekDays() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
