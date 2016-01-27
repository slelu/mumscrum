package edu.mum.scrum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
		//userStoryService.saveUserStory(userStory);
		ReleaseBacklog release =releaseService.getReleaseById(1);
		System.out.println(release.getName());
		release.addUserStory(userStory);
		releaseService.saveRelease(release);
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/editUserStory", method=RequestMethod.GET)
	public String editUserStory(UserStory userStory ,Model model,@RequestParam("id") Long id) {
		
		model.addAttribute("userStory", userStoryService.getUserStoryById(id));
		
		return "userStory";
	}
	
	@RequestMapping(value = "/deleteUserStory", method=RequestMethod.GET)
	public String deleteUserStory(UserStory userStory ,Model model,@RequestParam("id") Long id) {
		
		//model.addAttribute("userStory", userStoryService.getUserStory(id));
		releaseService.deleteUserStoryById(id);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/viewUserStory", method=RequestMethod.GET)
	public String viewUserStory(Model model) {
		
		model.addAttribute("userStory", userStoryService.getAllUserStories());
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/assignUserStory" ,method=RequestMethod.GET)
	public String assignUserStory(UserStory userStory ,Model model){
		
		model.addAttribute("developer",employeeService.getAvailableDev());
		model.addAttribute("tester",employeeService.getAvailableTesters());
		
		return "assignUs";
		
	}
	
}