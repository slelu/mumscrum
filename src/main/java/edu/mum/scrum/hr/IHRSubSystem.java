package edu.mum.scrum.hr;

import java.util.List;

import edu.mum.scrum.domain.Employee;



public interface IHRSubSystem {
	
	void saveEmployee(Employee employee);
	Employee getEmployee(Long id);
	void deleteEmployeeById(Long id);
	List <Employee> getAllEmployees();
	List<Employee> getAvailableDev();
	List<Employee> getAvailableTesters();
	void disableEmployee(Employee employee);
	void updateEmployee(Employee employee);
	Employee getEmployeeByName(String name);
	Employee getEmployeeByUsername(String username);



}
