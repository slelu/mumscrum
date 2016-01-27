package edu.mum.scrum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.scrum.domain.UserStory;

public interface UserStoryRepository extends JpaRepository<UserStory ,Long>{
	
	public int deleteByUserStoryId(Long id);

}
