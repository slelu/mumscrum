package edu.mum.scrum.domain;


import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
public class Sprint {
	@Id
	@GeneratedValue
	private long sprintId;
	

	private String sprintName;
	
	
	private Date startDate;
	
	private Date endDate;
	
	
	

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getSprintName() {
		return sprintName;
	}

	public void setSprintName(String sprintName) {
		this.sprintName = sprintName;
	}


	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@OneToMany(mappedBy="sprint", fetch=FetchType.EAGER)
	@Fetch (FetchMode.SELECT)
	private List<UserStory> userStories;
	
	@ManyToOne
	private ReleaseBacklog release;


	public long getSprintId() {
		return sprintId;
	}

	public void setSprintId(long sprintId) {
		this.sprintId = sprintId;
	}

	public List<UserStory> getUserStories() {
		return userStories;
	}

	public void setUserStories(List<UserStory> userStories) {
		this.userStories = userStories;
	}

	public ReleaseBacklog getRelease() {
		return release;
	}

	public void setRelease(ReleaseBacklog release) {
		this.release = release;
	}
	
	public Integer getTotalEstimate(){
		Integer estimate = 0;
		for (UserStory userStory: userStories) {
			estimate += userStory.getDevEstimate() + userStory.getTestEstimate();
		}
		return estimate;
	}
}
