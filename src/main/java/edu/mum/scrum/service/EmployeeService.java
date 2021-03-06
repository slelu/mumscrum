package edu.mum.scrum.service;

import java.util.List;

import edu.mum.scrum.domain.Employee;

public interface EmployeeService {
	void saveEmployee(Employee employee);
	public Employee getEmployeeById(Long id);
	List <Employee> getAllEmployees();
	List<Employee> getAvailableDev();
	List<Employee> getAvailableTesters();
	void disableEmployee(Employee employee);
	void updateEmployee(Employee employee);
	Employee getEmployeeByName(String name);
	Employee findByUsername(String username);
	boolean checkUserName(String username);

}
