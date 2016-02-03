package edu.mum.scrum.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.scrum.domain.Employee;
import edu.mum.scrum.hr.IHRSubSystem;
import edu.mum.scrum.service.RoleService;



/**
 * Handles requests for the application home page.
 */
@Controller
public class EmployeeController {
	
	
	@Autowired
	IHRSubSystem subSystemFacade;
	
	@Autowired 
	private RoleService roleService;
	
	BCryptPasswordEncoder en = new BCryptPasswordEncoder();
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/createEmployee", method = RequestMethod.GET)
	public String createEmployee(@ModelAttribute("employee") Employee employee, Model model) {
		return "employee";
	}
	
	@RequestMapping(value = "/createEmployee", method = RequestMethod.POST)
	public String saveEmployee(@Valid @ModelAttribute("employee") Employee employee,BindingResult result,
			@RequestParam("employeeId") Long id,Model model){
		
		if(result.hasErrors()){
			return "employee";
		}
		if(id==null){
		if(!subSystemFacade.checkUserName(employee.getUsername())){
			model.addAttribute("message","Username already Exists! ");
			return "employee";
		}
		}
		if (!(employee.getPassword().equals(employee.getPasswordConfirm()))) {
			model.addAttribute("message", "Passwords don't much!");
			return "employee";
		}
		
		employee.setPassword(en.encode(employee.getPassword()));
		
		
		System.out.println("----------hr"+employee.getPassword());
		
		subSystemFacade.saveEmployee(employee);
	
		return "redirect:/employeeList";
	}
	
	@RequestMapping(value = "/editEmployee", method=RequestMethod.GET)
	public String editEmployee(Employee employee ,Model model,@RequestParam("employeeId") Long id) {
		
		model.addAttribute("employee", subSystemFacade.getEmployee(id));	
		return "employee";
	}
	
	@RequestMapping(value="/employeeList", method=RequestMethod.GET)
	public String getAllSprint(Model model) {
		model.addAttribute("employees",subSystemFacade.getAllEmployees());
		
		return "employeeList";
	}
	
	@RequestMapping(value = "/deleteEmployee/{id}", method=RequestMethod.GET)
	public String deleteEmployee(@PathVariable("id") Long id) {
		Employee employee=subSystemFacade.getEmployee(id);
		System.out.println(employee.getFirstname());
		employee.setEnabled(false);	
		subSystemFacade.disableEmployee(employee);	
		
		return "redirect:/employeeList";
	}
	
	
	@RequestMapping(value = "/viewProfile", method=RequestMethod.GET)
	public String viewProfile(@ModelAttribute("employee") Employee employee ,Model model,Principal principal) {
		model.addAttribute("employee",subSystemFacade.findByUsername(principal.getName().toLowerCase()));
		return "profile";
	}
	
	@RequestMapping(value = "/updateProfile", method=RequestMethod.GET)
	public String updateProfile(Employee employee,@RequestParam("id") Long id
			,Model model) {
		
		model.addAttribute("employee", subSystemFacade.getEmployee(id));	
		return "updateProfile";
	}
	
	@RequestMapping(value = "/updateProfile", method=RequestMethod.POST)
	public String saveProfile(@Valid @ModelAttribute("employee") Employee employee ,BindingResult result
			,@RequestParam("employeeId") Long id,Model model) {
		if(result.hasErrors()){
			return "updateProfile";
		}
		if (!(employee.getPassword().equals(employee.getPasswordConfirm()))) {
			model.addAttribute("message", "Passwords don't much!");
			return "updateProfile";
		}
		employee.setRoles(subSystemFacade.getEmployee(id).getRoles());	
		employee.setPassword(en.encode(employee.getPassword()));
		System.out.println("----------------updated"+employee.getPassword());
		subSystemFacade.updateEmployee(employee);	
		return "redirect:/viewProfile";
	}
	
	
	@ModelAttribute
	public void init(Model model) {
		model.addAttribute("roles", roleService.getAllRoles() );
	}
	
}
