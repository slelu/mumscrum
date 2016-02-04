package edu.mum.scrum.service;

import java.util.List;

import edu.mum.scrum.domain.Role;

public interface RoleService  {
	
	public List<Role> getAllRoles();

   //public void saveRole(Role role);

	public Role findByRoleName(String roleName);
		
}
