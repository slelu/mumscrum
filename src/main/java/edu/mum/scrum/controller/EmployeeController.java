package edu.mum.scrum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.scrum.domain.Employee;
import edu.mum.scrum.service.EmployeeService;
import edu.mum.scrum.service.RoleService;


/**
 * Handles requests for the application home page.
 */
@Controller
public class EmployeeController {
	
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired 
	private RoleService roleService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/createEmployee", method = RequestMethod.GET)
	public String createEmployee(@ModelAttribute("employee") Employee employee, Model model) {
		model.addAttribute("roles", roleService.getAllRoles() );
		return "admin/employee";
	}
	
	@RequestMapping(value = "/createEmployee", method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute("employee") Employee employee){
		employeeService.saveEmployee(employee);
	
		return "redirect:/employeeList";
	}
	
	@RequestMapping(value = "/editEmployee", method=RequestMethod.GET)
	public String editUserStory(Employee employee ,Model model,@RequestParam("id") Long id) {
		
		model.addAttribute("employee", employeeService.getEmployee(id));
		model.addAttribute("roles", roleService.getAllRoles() );
		
		return "admin/employee";
	}
	
	@RequestMapping(value="/employeeList", method=RequestMethod.GET)
	public String getAllSprint(Model model) {
		model.addAttribute("employees",employeeService.getAllEmployees());
		
		return "admin/employeeList";
	}
	
	@RequestMapping(value = "/deleteEmployee/{id}", method=RequestMethod.GET)
	public String deleteEmployee(@PathVariable("id") long id) {
		Employee employee=employeeService.getEmployee(id);
		System.out.println(employee.getFirstname());
		employee.setEnabled(false);	
		employeeService.disableEmployee(employee);	
		
		return "redirect:/employeeList";
	}
	
	
	
}
