package edu.mum.scrum.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.scrum.domain.ReleaseBacklog;
import edu.mum.scrum.repository.ReleaseRepository;
import edu.mum.scrum.service.ReleaseService;

@Service
@Transactional
public class ReleaseServiceImpl implements ReleaseService{
	
	@Autowired 
	ReleaseRepository releaseRepository;

	@Override
	public void saveRelease(ReleaseBacklog release) {
		releaseRepository.save(release);
		
	}

	@Override
	public ReleaseBacklog getReleaseById(long releaseId) {
		return releaseRepository.findOne(releaseId);
	}

	@Override
	public int deleteUserStoryById(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ReleaseBacklog> getAllRelease() {
		
		return releaseRepository.findAll();
	}


}
