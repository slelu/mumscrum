package edu.mum.scrum.hr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.mum.scrum.domain.Employee;
import edu.mum.scrum.service.EmployeeService;





@Component
public class HRSusbSystemFacade implements IHRSubSystem{
	
	@Autowired 
	EmployeeService employeeService;
	

	@Override
	public void saveEmployee(Employee employee) {
		employeeService.saveEmployee(employee);
	}

	@Override
	public Employee getEmployee(Long id) {
		
		return employeeService.getEmployee(id);
	}

	@Override
	public void deleteEmployeeById(Long id) {
		employeeService.deleteEmployeeById(id);
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
	public void disableEmployee(Employee employee) {
		employeeService.disableEmployee(employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
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
	public boolean checkUserName(String string) {
		// TODO Auto-generated method stub
		return employeeService.checkUserName(string);
	}
	
	
	
}

