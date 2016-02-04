package edu.mum.scrum.hr;

import java.util.List;

import edu.mum.scrum.domain.Employee;
import edu.mum.scrum.domain.Role;



public interface IHRSubSystem {
	
	void saveEmployee(Employee employee);
	Employee getEmployeeById(Long id);
	List <Employee> getAllEmployees();
	List<Employee> getAvailableDev();
	List<Employee> getAvailableTesters();
	void updateProfile(Employee employee);
	Employee getEmployeeByName(String name);
	Employee findByUsername(String username);
	List<Role> getAllRoles();
	/*void createEmployee();*/

}

