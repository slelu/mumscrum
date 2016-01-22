package edu.mum.scrum.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Sprint {
	@Id
	private long sprintId;

	public long getSprintId() {
		return sprintId;
	}

	public void setSprintId(long sprintId) {
		this.sprintId = sprintId;
	}

}
