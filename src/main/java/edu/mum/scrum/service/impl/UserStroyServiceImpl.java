package edu.mum.scrum.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.scrum.domain.Employee;
import edu.mum.scrum.domain.UserStory;
import edu.mum.scrum.repository.UserStoryRepository;
import edu.mum.scrum.service.UserStoryService;

@Service 
@Transactional
public class UserStroyServiceImpl implements UserStoryService{
	
	@Autowired
	UserStoryRepository userStoryRepository;

	@Override
	public void saveUserStory(UserStory userStory) {
		userStoryRepository.save(userStory);
		
	}

	@Override
	public UserStory getUserStoryById(Long userstoryId) {
		
		return userStoryRepository.findOne(userstoryId);
	}

	@Override
	public int deleteUserStoryById(Long userStoryId) {
		
		return userStoryRepository.deleteByUserStoryId(userStoryId);
	}

	@Override
	public List<UserStory> getAllUserStories() {
		return userStoryRepository.findAll();
	}
	
	@Override
	public List<UserStory> getAllUserStoryByReleaseId(long id) {
		
		return userStoryRepository.findByRelease_ReleaseId(id);
	}

	@Override
	public List<UserStory> getAllUnestimatedDeveloperUserStories(Employee developer) {
		return userStoryRepository.findByAssignedDevAndDevEstimateNull(developer);
	}

	@Override
	public List<UserStory> getAllUnestimatedTesterUserStories(Employee tester) {
		return userStoryRepository.findByAssignedTesAndTestEstimateNull(tester);
	}

}
