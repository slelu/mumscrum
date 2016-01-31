package edu.mum.scrum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.scrum.domain.Role;
import edu.mum.scrum.domain.Sprint;

@Repository
public interface SprintRepository extends JpaRepository <Sprint, Long> {

	public Sprint findBySprintName(String name);
	
}