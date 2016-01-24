package edu.mum.scrum.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Sprint {
	@Id
	@GeneratedValue
	private long sprintId;
	
	private String sprintName;
	private int duration;
	private Date startDate;
	private Date endDate;
	
	public String getSprintName() {
		return sprintName;
	}

	public void setSprintName(String sprintName) {
		this.sprintName = sprintName;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public long getSprintId() {
		return sprintId;
	}

	public void setSprintId(long sprintId) {
		this.sprintId = sprintId;
	}

}
