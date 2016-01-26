package edu.mum.scrum.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.scrum.domain.Employee;
import edu.mum.scrum.domain.Role;
import edu.mum.scrum.repository.EmployeeRepository;
import edu.mum.scrum.repository.RoleRepository;
import edu.mum.scrum.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public void saveEmployee(Employee employee) {
		
		Set <Role> roles=new HashSet<Role>();
		
		for(Long id:employee.getRolesIds()){
			Role role=roleRepository.getOne(id);
			roles.add(role);
		}
		employee.setRoles(roles);
		employeeRepository.save(employee);
	}
	@Override
	public List<Employee> getAvailableDev() {
		List<Employee> avaDev = null;
		List<Employee> developers = employeeRepository.findByRoles_RoleName("developer");
		 for(Employee empl: developers){
			 if(empl.getUserStory().size()<3)
				 avaDev.add(empl);
		 }
		 return avaDev;
		
	}
	@Override
	public List<Employee> getAvailableTesters() {
		List<Employee> avaTes = null;
		List<Employee> testers = employeeRepository.findByRoles_RoleName("developer");
		 for(Employee empl: testers){
			 if(empl.getUserStory().size()<3)
				 avaTes.add(empl);
		 }
		 return avaTes;
		
	}

}
