package edu.mum.scrum.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
		BCryptPasswordEncoder en = new BCryptPasswordEncoder();
		employee.setPassword(en.encode(employee.getPassword()));
		Set <Role> roles=new HashSet<Role>();
		
		for(Long id:employee.getRolesIds()){
			Role role=roleRepository.findOne(id);
			roles.add(role);
		}
		employee.setRoles(roles);
		employeeRepository.save(employee);
	}
	@Override
	public List<Employee> getAvailableDev() {
		List<Employee> avaDev =new ArrayList<Employee>();
		List<Employee> developers = employeeRepository.findByRoles_RoleName("Developer");
		 for(Employee empl: developers){
			 if(empl.getUserStory().size()<3)
				 avaDev.add(empl);
		 }
		 return avaDev;
		
	}
	@Override
	public List<Employee> getAvailableTesters() {
	List<Employee> avaTes = new ArrayList<Employee>();
		List<Employee> testers = employeeRepository.findByRoles_RoleName("Tester");
		 for(Employee empl: testers){
			 if(empl.getUserStory().size()<3)
				 avaTes.add(empl);
		 }
		 return avaTes;
		
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

}
