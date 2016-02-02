package edu.mum.scrum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.scrum.domain.Role;

@Repository
public interface RoleRepository extends JpaRepository <Role, Long> {

	Role findByRoleName(String roleName);

}
