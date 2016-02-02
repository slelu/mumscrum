package edu.mum.scrum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.scrum.domain.Employee;
import edu.mum.scrum.domain.UserStory;

public interface UserStoryRepository extends JpaRepository<UserStory ,Long>{
	
	public int deleteByUserStoryId(Long id);
	
	public List<UserStory> findByRelease_ReleaseId(long id);

	public List<UserStory> findByAssignedDevAndDevEstimateNull(Employee developer);
	
	public List<UserStory> findByAssignedTesAndTestEstimateNull(Employee tester);
	
	public List<UserStory> findByAssignedDevAndStateAndDevEstimateNotNullAndTestEstimateNotNull(Employee developer, String state);
	
	public List<UserStory> findByAssignedTesAndStateAndDevEstimateNotNullAndTestEstimateNotNull(Employee tester, String state);
}

