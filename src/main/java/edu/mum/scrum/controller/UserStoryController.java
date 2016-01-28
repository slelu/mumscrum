package edu.mum.scrum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.scrum.domain.Employee;
import edu.mum.scrum.domain.ReleaseBacklog;
import edu.mum.scrum.domain.UserStory;
import edu.mum.scrum.service.EmployeeService;
import edu.mum.scrum.service.ReleaseService;
import edu.mum.scrum.service.UserStoryService;

@Controller
public class UserStoryController {
	@Autowired
	UserStoryService userStoryService;
	@Autowired
	ReleaseService releaseService;
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value="/createUserStory" ,method=RequestMethod.GET)
	public String createUserStory(@ModelAttribute("userStory") UserStory userStory){
		
		return "userStory";
		
	}
	
	@RequestMapping(value="/createUserStory", method=RequestMethod.POST)
	public String saveUserStory(@ModelAttribute("userStory") UserStory userStory ){
		
		ReleaseBacklog release =releaseService.getReleaseById(1);
		userStory.setRelease(release);
		userStoryService.saveUserStory(userStory);
			
		return "redirect:/viewUserStory";
	}
	
	@RequestMapping(value = "/editUserStory", method=RequestMethod.GET)
	public String editUserStory(UserStory userStory ,Model model,@RequestParam("id") Long id) {
		
		model.addAttribute("userStory", userStoryService.getUserStoryById(id));
		
		return "userStory";
	}
	
	@RequestMapping(value = "/deleteUserStory", method=RequestMethod.GET)
	public String deleteUserStory(UserStory userStory ,Model model,@RequestParam("id") Long id) {
		
		userStoryService.deleteUserStoryById(id);
		return "redirect:/viewUserStory";
	}
	
	@RequestMapping(value = "/viewUserStory", method=RequestMethod.GET)
	public String viewUserStory(Model model) {
		
		model.addAttribute("userStories", userStoryService.getAllUserStories());
		
		return "userStoryList";
	}
	
	@RequestMapping(value="/assignUserStory" ,method=RequestMethod.GET)
	public String assignUserStory(@ModelAttribute("userStory")UserStory userStory , @RequestParam("id") Long id ,Model model){
		
		model.addAttribute("userStory",userStoryService.getUserStoryById(id));
		model.addAttribute("developers",employeeService.getAvailableDev());
		model.addAttribute("testers",employeeService.getAvailableTesters());
		
		return "assignUs";
		
	}
	@RequestMapping(value="/assignUserStory" ,method=RequestMethod.POST)
	public String saveAssignUserStory(@RequestParam("id") Long id,@RequestParam("developer") String devName,
			@RequestParam("tester") String testName,Model model){
		
		UserStory userStory = userStoryService.getUserStoryById(id);
		if (!devName.equals("NONE")){
		userStory.setAssignedDev(employeeService.getEmployeeByName(devName));
		}
		if (!testName.equals("NONE")){
		userStory.setAssignedTes(employeeService.getEmployeeByName(testName));
		}
		userStoryService.saveUserStory(userStory);
		
		return "redirect:/viewUserStory";
	}
}