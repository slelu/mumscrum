package edu.mum.scrum.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.scrum.domain.Employee;
import edu.mum.scrum.domain.UserStory;
import edu.mum.scrum.service.EmployeeService;
import edu.mum.scrum.service.UserStoryService;

/**
 * @author Filmon
 * Controls the testing effort estimation by a tester
 */
@Controller
public class TesterController {
	@Autowired
	private UserStoryService userStoryService;
	
	@Autowired EmployeeService employeeService;
	
	@ModelAttribute("testerUserStoriesToBeEstimated")
	public List<UserStory> getAllUnestimatedUserStories(Employee developer, Model model, Principal principal){
		
		Employee e = employeeService.findByUsername(principal.getName().toLowerCase());

		List<UserStory> unestimatedUserStories = userStoryService.getAllUnestimatedTesterUserStories(e);
		
		if(unestimatedUserStories.isEmpty()){
			model.addAttribute("EMPTY_LIST", "You don't have un-eastimated user stories!");
		}
		return unestimatedUserStories;
	}
	
	@RequestMapping(value="/testerUserStoryList", method=RequestMethod.GET)
	public String list(){
		return "testerUserStoryList";
	}
	
	@RequestMapping(value="/testerEstimate", method=RequestMethod.GET)
	public String getUserStoryToEstimate(@RequestParam Long userStoryId, Model model){
		model.addAttribute("testerUserStory", userStoryService.getUserStoryById(userStoryId));
		return "estimateTesterUserStory";
	}
	
	@RequestMapping(value="/testerEstimate", method=RequestMethod.POST)
	public String updateUserStory(@Valid @ModelAttribute("testerUserStory") UserStory testerUserStory,BindingResult result, final RedirectAttributes redirectAttributes){
		String view = "redirect:/testerUserStoryList";
		if (!result.hasErrors()) {
			UserStory u =userStoryService.getUserStoryById(testerUserStory.getUserStoryId());
			u.setDevEstimate(testerUserStory.getDevEstimate());
			u.setTestEstimate(testerUserStory.getTestEstimate());
			if(u.isEstimated()){
				u.setState("IN-PROGRESS");
			}
			userStoryService.saveUserStory(u);
			redirectAttributes.addFlashAttribute("SUCCESS_MESSAGE", "User Story development time estimated Successfully !");
		} else {
			view = "estimateTesterUserStory";
		}
		return view;
	}
	
	@RequestMapping(value="/testerNewWorklog", method=RequestMethod.GET)
	public String newWorklog(){
		return "testerNewWorklog";
	}
	
}
