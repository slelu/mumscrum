package edu.mum.scrum.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Sprint {
	@Id
	@GeneratedValue
	private long sprintId;
	
	@OneToMany(mappedBy="sprint")
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

}
