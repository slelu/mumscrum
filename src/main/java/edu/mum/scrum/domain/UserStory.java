package edu.mum.scrum.domain;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class UserStory {
	@Id 
	@GeneratedValue
	private long userStoryId;
	private String name;
	private String priority;
	private int devEstimate;
	private int testEstimate;
	private String state;
	
	@OneToOne
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

	public int getDevEstimate() {
		return devEstimate;
	}

	public void setDevEstimate(int devEstimate) {
		this.devEstimate = devEstimate;
	}

	public int getTestEstimate() {
		return testEstimate;
	}

	public void setTestEstimate(int testEstimate) {
		this.testEstimate = testEstimate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	

}
