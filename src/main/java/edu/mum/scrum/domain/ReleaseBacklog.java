package edu.mum.scrum.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ReleaseBacklog {
	@Id
	@GeneratedValue
	private long releaseId;
	private String name;
	private String description;
	private Date startDate ;
	private Date endDate;
	@OneToMany
	private List<UserStory> userStories;
	@OneToMany
	private List<Sprint> sprints;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public List<UserStory> getUserStories() {
		return userStories;
	}
	public void setUserStories(List<UserStory> userStories) {
		this.userStories = userStories;
	}
	public List<Sprint> getSprints() {
		return sprints;
	}
	public void setSprints(List<Sprint> sprints) {
		this.sprints = sprints;
	}
	public long getReleaseId() {
		return releaseId;
	}
	public void setReleaseId(long releaseId) {
		this.releaseId = releaseId;
	}
	

}
