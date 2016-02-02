package edu.mum.scrum.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

@Entity
public class UserStory {
	@Id 
	@GeneratedValue
	private Long userStoryId;
	@NotEmpty(message="can not be Empty")
	private String name;
	@NotEmpty(message="can not be Empty")
	private String priority;
	@Min(1)
	private Integer devEstimate;
	@Min(1)
	private Integer testEstimate;
	private String state;
	
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.REFRESH)
	private Employee assignedDev;
	@OneToOne
	private Employee assignedTes;
	
	@NotEmpty(message="can not be Empty")
	private String description;
	
	@ManyToOne
	private ReleaseBacklog release;
	
	@ManyToOne
	private Sprint sprint ;
	

	public Long getUserStoryId() {
		return userStoryId;
	}

	public void setUserStoryId(Long userStoryId) {
		this.userStoryId = userStoryId;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee getAssignedDev() {
		return assignedDev;
	}

	public void setAssignedDev(Employee assignedDev) {
		this.assignedDev = assignedDev;
	}

	public Employee getAssignedTes() {
		return assignedTes;
	}

	public void setAssignedTes(Employee assignedTes) {
		this.assignedTes = assignedTes;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public ReleaseBacklog getRelease() {
		return release;
	}

	public void setRelease(ReleaseBacklog release) {
		this.release = release;
	}

	public Sprint getSprint() {
		return sprint;
	}

	public void setSprint(Sprint sprint) {
		this.sprint = sprint;
	}
	
	public Integer getDevEstimate() {
		return devEstimate;
	}

	public void setDevEstimate(Integer devEstimate) {
		this.devEstimate = devEstimate;
	}

	public Integer getTestEstimate() {
		return testEstimate;
	}

	public void setTestEstimate(Integer testEstimate) {
		this.testEstimate = testEstimate;
	}
	
	public boolean isEstimated(){
		return this.devEstimate != null && this.testEstimate != null;
	}
}
