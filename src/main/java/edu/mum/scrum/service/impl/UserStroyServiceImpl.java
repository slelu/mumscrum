package edu.mum.scrum.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.scrum.domain.Employee;
import edu.mum.scrum.domain.Sprint;
import edu.mum.scrum.domain.UserStory;
import edu.mum.scrum.repository.SprintRepository;
import edu.mum.scrum.repository.UserStoryRepository;
import edu.mum.scrum.service.UserStoryService;

@Service 
@Transactional
public class UserStroyServiceImpl implements UserStoryService{
	
	@Autowired
	UserStoryRepository userStoryRepository;
	@Autowired
	SprintRepository  sprintRepository;

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
	
	public void saveUserStoryById(long userStoryId ,String sprintName){
		
		UserStory userStory = this.getUserStoryById(userStoryId);
		Sprint  sprint=sprintRepository.findBySprintName(sprintName);
		userStory.setSprint(sprint);
		sprint.setRelease(userStory.getRelease());
		sprintRepository.save(sprint);
		userStory.setRelease(null);
		userStoryRepository.save(userStory);
		}

		@Override
		public boolean checkUserStoryName(String name) {
			for(UserStory us:userStoryRepository.findAll()){
				if(us.getName().equals(name))
					return false;
			}
			return true;
		}

	@Override
	public List<UserStory> getAllUserStoryBySprintId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserStory> getAllEstimatedDeveloperUserStories(Employee developer) {
		return userStoryRepository.findByAssignedDevAndStateAndDevEstimateNotNullAndTestEstimateNotNull(developer, "IN-PROGRESS");
	}

	@Override
	public List<UserStory> getAllEstimatedTesterUserStories(Employee tester) {
		return userStoryRepository.findByAssignedTesAndStateAndDevEstimateNotNullAndTestEstimateNotNull(tester, "IN-PROGRESS");
	}

	
}

