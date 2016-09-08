package edu.mum.scrum.hr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.mum.scrum.domain.Employee;
import edu.mum.scrum.domain.Role;
import edu.mum.scrum.service.EmployeeService;
import edu.mum.scrum.service.RoleService;





@Component
public class HRSusbSystemFacade implements IHRSubSystem{
	
	@Autowired 
	EmployeeService employeeService;
	@Autowired 
	RoleService roleService;
	

	@Override
	public void saveEmployee(Employee employee) {
		employeeService.saveEmployee(employee);
	}

	@Override
	public Employee getEmployeeById(Long id) {
		
		return employeeService.getEmployeeById(id);
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		return employeeService.getAllEmployees();
	}

	@Override
	public List<Employee> getAvailableDev() {
		
		return employeeService.getAvailableDev();
	}

	@Override
	public List<Employee> getAvailableTesters() {
		
		return employeeService.getAvailableTesters();
	}

	@Override
	public void updateProfile(Employee employee) {
		employeeService.updateEmployee(employee);
	}

	@Override
	public Employee getEmployeeByName(String name) {
		
		return employeeService.getEmployeeByName(name);
	}

	@Override
	public Employee findByUsername(String username) {
		
		return employeeService.findByUsername(username);
	}

	@Override
	public List<Role> getAllRoles() {
		
		return roleService.getAllRoles();
	}

	/*@Override
	public void createEmployee() {
		employeeService.
		
	}
	*/
	
	
}

