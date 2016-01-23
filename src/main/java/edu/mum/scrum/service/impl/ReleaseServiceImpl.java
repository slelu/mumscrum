package edu.mum.scrum.service.impl;

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
	
	

}
