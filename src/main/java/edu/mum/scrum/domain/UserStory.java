package edu.mum.scrum.domain;



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class UserStory {
	@Id 
	@GeneratedValue
	private long userStoryId;
	private String name;
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
	private String description;
	

	public long getUserStoryId() {
		return userStoryId;
	}

	public void setUserStoryId(long userStoryId) {
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
