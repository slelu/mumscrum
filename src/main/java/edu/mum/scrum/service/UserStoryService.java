package edu.mum.scrum.service;

import java.util.List;
import edu.mum.scrum.domain.UserStory;

public interface UserStoryService {
	
	public void saveUserStory(UserStory userStory);
	public UserStory getUserStoryById(Long userstoryId);
	public int deleteUserStoryById(Long userStoryId);
	public List<UserStory> getAllUserStories();
    public List<UserStory> getAllUserStoryByReleaseId(long id);
    void saveUserStoryById(long userStoryId ,String sprintName);
    boolean checkUserStoryName(String name);
	}



