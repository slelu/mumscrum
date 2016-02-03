package edu.mum.scrum.controller;

import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.scrum.domain.Employee;
import edu.mum.scrum.domain.Role;
import edu.mum.scrum.domain.UserStory;
import edu.mum.scrum.service.EmployeeService;
import edu.mum.scrum.service.RoleService;
import edu.mum.scrum.service.UserStoryService;

/**
 * @author Filmon
 * User Authentication and authorization, handled by the spring security
 */
@Controller
public class LoginController {

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(){
		return "login";
	}
/*	
@Autowired
	private RoleService roleService;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private UserStoryService userStoryService;
	
@PostConstruct
	public void initialize(){
		initializeRoles();
		initializeEmployees();
		initializeUserStories();
	}


	private void initializeUserStories() {
		UserStory userStoryOne = new UserStory();
		userStoryOne.setName("User Story - 1");
		userStoryOne.setDescription("User Story - 1 description");
		userStoryOne.setState("NEW");
		userStoryOne.setPriority("1");
		userStoryOne.setAssignedDev(employeeService.findByUsername("filmon"));
		userStoryOne.setAssignedTes(employeeService.findByUsername("luwam"));
		userStoryService.saveUserStory(userStoryOne);
		
		UserStory userStoryTwo = new UserStory();
		userStoryTwo.setName("User Story - 2");
		userStoryTwo.setDescription("User Story - 2 description");
		userStoryTwo.setState("NEW");
		userStoryTwo.setPriority("1");
		userStoryTwo.setAssignedDev(employeeService.findByUsername("filmon"));
		userStoryTwo.setAssignedTes(employeeService.findByUsername("luwam"));
		userStoryService.saveUserStory(userStoryTwo);
		
		UserStory userStoryThree = new UserStory();
		userStoryThree.setName("User Story - 3");
		userStoryThree.setDescription("User Story - 3 description");
		userStoryThree.setState("NEW");
		userStoryThree.setPriority("1");
		userStoryThree.setAssignedDev(employeeService.findByUsername("simona"));
		userStoryThree.setAssignedTes(employeeService.findByUsername("simona"));
		userStoryService.saveUserStory(userStoryThree);
	}


	private void initializeEmployees() {
		BCryptPasswordEncoder en = new BCryptPasswordEncoder();
		
		Employee employeeOne = new Employee();
		employeeOne.setEnabled(true);
		employeeOne.setFirstname("Filmon");
		employeeOne.setLastname("Tekle");
		employeeOne.setUsername("filmon");
		employeeOne.setPassword(en.encode("filmon"));
		employeeOne.addRole(roleService.findByRoleName("DEVELOPER"));
		ArrayList<Long> a = new ArrayList<>();
		a.add(roleService.findByRoleName("DEVELOPER").getRoleId());
		employeeOne.setRolesIds(a);
		
		employeeService.saveEmployee(employeeOne);
		
		
		Employee employeeTwo = new Employee();
		employeeTwo.setEnabled(true);
		employeeTwo.setFirstname("Luwam");
		employeeTwo.setLastname("Alem");
		employeeTwo.setUsername("luwam");
		employeeTwo.setPassword(en.encode("luwam"));
		employeeTwo.addRole(roleService.findByRoleName("TESTER"));
		ArrayList<Long> b = new ArrayList<>();
		b.add(roleService.findByRoleName("TESTER").getRoleId());
		employeeOne.setRolesIds(b);
		
		employeeService.saveEmployee(employeeTwo);
		
		
		Employee employeeThree = new Employee();
		employeeThree.setEnabled(true);
		employeeThree.setFirstname("Simona");
		employeeThree.setLastname("Debessai");
		employeeThree.setUsername("simona");
		employeeThree.setPassword(en.encode("simona"));
		employeeThree.addRole(roleService.findByRoleName("DEVELOPER"));
		employeeThree.addRole(roleService.findByRoleName("TESTER"));
		ArrayList<Long> c = new ArrayList<>();
		c.add(roleService.findByRoleName("DEVELOPER").getRoleId());
		c.add(roleService.findByRoleName("TESTER").getRoleId());
		employeeOne.setRolesIds(c);
		
		employeeService.saveEmployee(employeeThree);
		
		Employee employeeFour = new Employee();
		employeeFour.setEnabled(false);
		employeeFour.setFirstname("Dawit");
		employeeFour.setLastname("Maekele");
		employeeFour.setUsername("dawit");
		employeeFour.setPassword(en.encode("dawit"));
		employeeFour.addRole(roleService.findByRoleName("DEVELOPER"));
		ArrayList<Long> d = new ArrayList<>();
		d.add(roleService.findByRoleName("DEVELOPER").getRoleId());
		employeeOne.setRolesIds(d);
		
		employeeService.saveEmployee(employeeFour);
		
	}


	private void initializeRoles() {
		Role roleDeveloper = new Role();
		roleDeveloper.setRoleName("DEVELOPER");
		roleService.saveRole(roleDeveloper);
		
		Role roleTester = new Role();
		roleTester.setRoleName("TESTER");
		roleService.saveRole(roleTester);
		
		Role roleScrumMaster = new Role();
		roleScrumMaster.setRoleName("SCRUM MASTER");
		roleService.saveRole(roleScrumMaster);
		
		Role roleHrAdmin = new Role();
		roleHrAdmin.setRoleName("HR ADMIN");
		roleService.saveRole(roleHrAdmin);
	}*/
}
