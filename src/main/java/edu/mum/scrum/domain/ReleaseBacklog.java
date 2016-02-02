package edu.mum.scrum.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class ReleaseBacklog {
	@Id
	@GeneratedValue
	private long releaseId;
	@NotEmpty(message="can not be Empty")
	private String name;
	@NotEmpty(message="can not be Empty")
	private String description;
	private Date startDate ;
	private Date endDate;
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy="release")
	private List<UserStory> userStories;
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy="release")
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
	 public void addUserStory(UserStory userStory){
		 this.userStories.add(userStory);
	 }
	 
	 public void addSprint(Sprint sprint){
		 this.sprints.add(sprint);
	 }
	
}
