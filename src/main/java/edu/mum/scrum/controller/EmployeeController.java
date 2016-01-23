package edu.mum.scrum.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	RoleService roleService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/createEmployee", method = RequestMethod.GET)
	public String createEmployee(@ModelAttribute("employee") Employee employee, Model model) {
		model.addAttribute("roles", roleService.getAllRoles() );
		return "admin/createEmployee";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute("employee") Employee employee){
		employeeService.saveEmployee(employee);
		return "home";
	}
	
	
	
}
