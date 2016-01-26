package edu.mum.scrum.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class UserStory {
	@Id 
	private long userStoryId;
	private String priority;
	
	private int devEstimate;
	private int tesEstimate;
	/*@OneToMany
	private List <Employee> assignedTo;*/
	private Date dueDate;
	//private ReleaseBacklog release;
	private String description;
	

	
	
	public int getDevEstimate() {
		return devEstimate;
	}

	public void setDevEstimate(int devEstimate) {
		this.devEstimate = devEstimate;
	}

	public int getTesEstimate() {
		return tesEstimate;
	}

	public void setTesEstimate(int tesEstimate) {
		this.tesEstimate = tesEstimate;
	}

	public long getUserStoryId() {
		return userStoryId;
	}

	public void setUserStoryId(long userStoryId) {
		this.userStoryId = userStoryId;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	/*public List<Employee> getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(List<Employee> assignedTo) {
		this.assignedTo = assignedTo;
	}*/

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	/*public ReleaseBacklog getRelease() {
		return release;
	}

	public void setRelease(ReleaseBacklog release) {
		this.release = release;
	}*/

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
