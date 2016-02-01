package edu.mum.scrum.service;

import java.util.List;


import edu.mum.scrum.domain.Sprint;

public interface SprintService {
	public void saveSprint(Sprint sprint);
	public List<Sprint> getAllSprints();
	public Sprint getSprintById(Long id);
	public int getTotalEstimate(Long id);
	public Sprint searchSprintByName(String name);
	public void deleteSprintById(Long id);

}
