package edu.mum.scrum.service.impl;

import java.util.ArrayList;
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
			Role role=roleRepository.findOne(id);
			roles.add(role);
		}
		employee.setRoles(roles);
		employeeRepository.save(employee);
	}


	@Override
	public Employee getEmployee(Long id) {
		
		return employeeRepository.findOne(id);
	}


	@Override
	public void deleteEmployee(Long id) {
		
		employeeRepository.delete(id);
		
	}


	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

}
