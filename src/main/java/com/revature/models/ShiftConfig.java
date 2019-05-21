package com.revature.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class ShiftConfig {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	private int startTime;
	@NotNull
	private int endTime;
	@NotNull
	private WeekDays weekdays;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStartTime() {
		return startTime;
	}
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	public int getEndTime() {
		return endTime;
	}
	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
	public WeekDays getWeekdays() {
		return weekdays;
	}
	public void setWeekdays(WeekDays weekdays) {
		this.weekdays = weekdays;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + endTime;
		result = prime * result + id;
		result = prime * result + startTime;
		result = prime * result + ((weekdays == null) ? 0 : weekdays.hashCode());
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
		ShiftConfig other = (ShiftConfig) obj;
		if (endTime != other.endTime)
			return false;
		if (id != other.id)
			return false;
		if (startTime != other.startTime)
			return false;
		if (weekdays == null) {
			if (other.weekdays != null)
				return false;
		} else if (!weekdays.equals(other.weekdays))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ShiftConfig [id=" + id + ", startTime=" + startTime + ", endTime=" + endTime + ", weekdays=" + weekdays
				+ "]";
	}
	public ShiftConfig(int id, @NotNull int startTime, @NotNull int endTime, @NotNull WeekDays weekdays) {
		super();
		this.id = id;
		this.startTime = startTime;
		this.endTime = endTime;
		this.weekdays = weekdays;
	}
	public ShiftConfig() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
