package edu.mum.scrum.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserStory {
	@Id 
	private long userStoryId;

	public long getUserStoryId() {
		return userStoryId;
	}

	public void setUserStoryId(long userStoryId) {
		this.userStoryId = userStoryId;
	}

}
