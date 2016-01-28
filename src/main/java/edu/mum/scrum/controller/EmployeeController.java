package edu.mum.scrum.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.scrum.domain.Employee;
import edu.mum.scrum.domain.Role;
import edu.mum.scrum.domain.Sprint;
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
		return "admin/createEmployee";
	}
	
	@RequestMapping(value = "/createEmployee", method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute("employee") Employee employee,RedirectAttributes redirectAttributes){
		employeeService.saveEmployee(employee);
		redirectAttributes.addFlashAttribute("success" ,"New Employee Succesfully Created");
		return "redirect:/";
	}
	
	@RequestMapping(value="/employeeList", method=RequestMethod.GET)
	public String getAllSprint(Model model) {
		model.addAttribute("employees",employeeService.getAllEmployees());
		
		return "employeeList";
	}
	
	@RequestMapping(value = "/editEmployee/{id}", method=RequestMethod.GET)
	public String editEmployee(Model model, @PathVariable("id") Long id) {
		
		
		model.addAttribute("employee",employeeService.getEmployee(id) );
		model.addAttribute("roles",roleService.getAllRoles());
		
		return "admin/editEmployee";
	}
	
	@RequestMapping(value = "/editEmployee/{id}", method=RequestMethod.POST)
	public String updateEmployee( Employee employee,RedirectAttributes redirectAttributes,@PathVariable Long id) {
		
		    employeeService.updateEmployee(employee);
			redirectAttributes.addFlashAttribute("success" ,"Employee Succesfully Edited");
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/deleteEmployee/{id}", method=RequestMethod.GET)
	public String deleteEmployee(@PathVariable("id") long id,RedirectAttributes redirectAttributes) {
		Employee employee=employeeService.getEmployee(id);
		System.out.println(employee.getFirstname());
		employee.setEnabled(false);
		
		employeeService.disableEmployee(employee);	
		
		System.out.println(employee.isEnabled());
		
		redirectAttributes.addFlashAttribute("success" ,"Employee Succesfully Disabled");
		return "redirect:/";
	}
	
	
	
}
