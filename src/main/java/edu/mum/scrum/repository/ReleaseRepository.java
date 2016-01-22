package edu.mum.scrum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.scrum.domain.ReleaseBacklog;

@Repository
public interface ReleaseRepository extends JpaRepository <ReleaseBacklog, Long>{

}

