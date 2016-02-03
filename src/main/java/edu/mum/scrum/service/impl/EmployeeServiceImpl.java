
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
			Role role=roleRepository.getOne(id);
			roles.add(role);
		}
		employee.setRoles(roles);
		employeeRepository.save(employee);
	}
	@Override
	public List<Employee> getAvailableDev() {
		List<Employee> avaDev = new ArrayList();
		List<Employee> developers = employeeRepository.findByRoles_RoleName("DEVELOPER");
		 for(Employee empl: developers){
			 if(empl.getUserStory().size()<3)
				 avaDev.add(empl);
		 }
		 return avaDev;
		
	}
	@Override
	public List<Employee> getAvailableTesters() {
		List<Employee> avaTes = new ArrayList();
		List<Employee> testers = employeeRepository.findByRoles_RoleName("TESTER");
		 for(Employee empl: testers){
			 if(empl.getUserStory().size()<3)
				 avaTes.add(empl);
		 }
		 return avaTes;
		
	}
	@Override
	public Employee getEmployeeById(Long employeeId) {
		return employeeRepository.findByEmployeeId(employeeId);
	}
	@Override
	public Employee findByUsername(String username) {
		return employeeRepository.findByUsername(username);
	}
	
	@Override
	public Employee getEmployeeByName(String name) {
		return employeeRepository.findByFirstname(name);
	}


	@Override
	public Employee getEmployee(Long id) {
		
		return employeeRepository.findOne(id);
	}


	@Override
	public void deleteEmployeeById(Long id) {
		
		employeeRepository.deleteByEmployeeId(id);
		
	}


	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
	@Override
	public void disableEmployee(Employee employee) {
		
		employeeRepository.save(employee);
		
	}
	@Override
	public void updateEmployee(Employee employee) {
		
		employeeRepository.save(employee);
	}
	@Override
	public boolean checkUserName(String username) {
		
		for(Employee e:employeeRepository.findAll()){
		if(e.getUsername().equals(username))
			return false;
		}
		return true;
	}

}

