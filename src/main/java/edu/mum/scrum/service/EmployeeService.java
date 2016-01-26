package edu.mum.scrum.service;

import java.util.List;

import edu.mum.scrum.domain.Employee;

public interface EmployeeService {
	void saveEmployee(Employee employee);
	Employee getEmployee(Long id);
	void deleteEmployee(Long id);
	List <Employee> getAllEmployees();
	
}
