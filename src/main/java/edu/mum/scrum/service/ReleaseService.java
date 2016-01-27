package edu.mum.scrum.service;

import edu.mum.scrum.domain.ReleaseBacklog;

public interface ReleaseService {
	
	public void saveRelease(ReleaseBacklog release);
	public ReleaseBacklog getReleaseById(long  i);
	public int deleteUserStoryById(Long id );

}
