package edu.mum.scrum.service;

import java.util.List;

import edu.mum.scrum.domain.ReleaseBacklog;

public interface ReleaseService {
	
	 void saveRelease(ReleaseBacklog release);
	 ReleaseBacklog getReleaseById(long  i);
	 int deleteUserStoryById(Long id );
	 List<ReleaseBacklog> getAllRelease();
	

}
