package edu.mum.scrum.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class WorkLog {
	
	@Id
	@GeneratedValue
	private Long workLogId;
	private LocalDateTime time;
	private Integer workHours;
	
	
	public Long getWorkLogId() {
		return workLogId;
	}
	public void setWorkLogId(Long workLogId) {
		this.workLogId = workLogId;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	public Integer getWorkHours() {
		return workHours;
	}
	public void setWorkHours(Integer workHours) {
		this.workHours = workHours;
	}
	
	
}
