package com.revature.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
public class ShiftConfig {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	private int startTime;
	
	@NotNull
	private int endTime;
	
	@OneToOne
	@JoinColumn(name = "weekDays_id")
	private WeekDays weekdays;
	
	@NotNull
	private int numberOfEmployees;
	
	@ManyToOne
	@JoinColumn(name = "users_id")
	private Users users;

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

	public int getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployees(int numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
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
		result = prime * result + endTime;
		result = prime * result + id;
		result = prime * result + numberOfEmployees;
		result = prime * result + startTime;
		result = prime * result + ((users == null) ? 0 : users.hashCode());
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
		if (numberOfEmployees != other.numberOfEmployees)
			return false;
		if (startTime != other.startTime)
			return false;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
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
				+ ", numberOfEmployees=" + numberOfEmployees + ", users=" + users + "]";
	}

	public ShiftConfig(int id, @NotNull int startTime, @NotNull int endTime, WeekDays weekdays,
			@NotNull int numberOfEmployees, Users users) {
		super();
		this.id = id;
		this.startTime = startTime;
		this.endTime = endTime;
		this.weekdays = weekdays;
		this.numberOfEmployees = numberOfEmployees;
		this.users = users;
	}

	public ShiftConfig() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
