package edu.mum.scrum.service;

import java.util.List;

import edu.mum.scrum.domain.Employee;

public interface EmployeeService {
	void saveEmployee(Employee employee);
	
	List<Employee> getAvailableDev();
	List<Employee> getAvailableTesters();	
	Employee getEmployeeByName(String name);
}
