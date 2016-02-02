package edu.mum.scrum.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.scrum.domain.Role;
import edu.mum.scrum.repository.RoleRepository;
import edu.mum.scrum.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	RoleRepository roleRepository;

	@Override
	public List<Role> getAllRoles() {
		return roleRepository.findAll();
	}

	@Override
	public void saveRole(Role role) {
		roleRepository.save(role);
	}

	@Override
	public Role findByRoleName(String roleName) {
		return roleRepository.findByRoleName(roleName);
	}

}
