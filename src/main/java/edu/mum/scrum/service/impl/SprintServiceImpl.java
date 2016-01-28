package edu.mum.scrum.service.impl;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.scrum.domain.Sprint;
import edu.mum.scrum.domain.UserStory;
import edu.mum.scrum.repository.SprintRepository;
import edu.mum.scrum.service.SprintService;


@Service
@Transactional
public class SprintServiceImpl implements SprintService {

	@Autowired
	SprintRepository sprintRepository;
	
	@Override
	public void saveSprint(Sprint sprint) {
		sprintRepository.save(sprint);
		
	}

	@Override
	public List <Sprint> getAllSprints() {	
		return sprintRepository.findAll();
	}

	@Override
	public Sprint getSprintById(Long id) {
		
		return sprintRepository.findOne(id);
	}

	@Override
	public int getTotalEstimate(Long id) {
		int total=0;
		Sprint sprint=sprintRepository.findOne(id);
		List <UserStory> userStories=sprint.getUserStories(); //Make the query only for userstories that are assigned
		
		for(UserStory u:userStories){
			total+=u.getDevEstimate()+u.getTestEstimate();
		}
		return total;
		
	}

	@Override
	public Sprint searchSprintByName(String name) {
		
		return sprintRepository.findBySprintName(name);
	}

	@Override
	public void deleteSprintById(Long id) {
		sprintRepository.delete(id);
		
	}
	
	

}
