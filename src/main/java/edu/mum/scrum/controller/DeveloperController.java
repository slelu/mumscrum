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
import edu.mum.scrum.domain.WorkLog;
import edu.mum.scrum.hr.IHRSubSystem;
import edu.mum.scrum.service.UserStoryService;

/**
 * @author Filmon
 * Controls the user story estimation flow for development effort
 */
@Controller
public class DeveloperController {
	@Autowired
	private UserStoryService userStoryService;
	
	@Autowired IHRSubSystem ihrSubSystem;
	
	@ModelAttribute("developerUserStoriesToBeEstimated")
	public List<UserStory> getAllUnestimatedUserStories(Employee developer,Model model, Principal principal){
		
		Employee dev = ihrSubSystem.getEmployeeByUsername(principal.getName());

		List<UserStory> unestimatedUserStories = userStoryService.getAllUnestimatedDeveloperUserStories(dev);
		
		if(unestimatedUserStories.isEmpty()){
			model.addAttribute("EMPTY_LIST_UNESTIMATED", "You don't have un-eastimated user stories!");
		}
		return unestimatedUserStories;
	}
	
	@RequestMapping(value="/developerUserStoryList", method=RequestMethod.GET)
	public String unestimatedUserStoryList(){
		return "developerUserStoryList";
	}

	@RequestMapping(value="/developerEstimate", method=RequestMethod.GET)
	public String getUserStoryToEstimate(@RequestParam Long userStoryId, Model model){
		model.addAttribute("developerUserStory", userStoryService.getUserStoryById(userStoryId));
		return "estimateDeveloperUserStory";
	}
	
	@RequestMapping(value="/developerEstimate", method=RequestMethod.POST)
	public String updateUserStory(@Valid @ModelAttribute("developerUserStory") UserStory developerUserStory,BindingResult result, final RedirectAttributes redirectAttributes){
		String view = "redirect:/developerUserStoryList";
		if (!result.hasErrors()) {
			UserStory u =userStoryService.getUserStoryById(developerUserStory.getUserStoryId());
			u.setDevEstimate(developerUserStory.getDevEstimate());
			if(u.isEstimated()){
				u.setState("IN-PROGRESS");
			}
			userStoryService.saveUserStory(u);
			redirectAttributes.addFlashAttribute("SUCCESS_MESSAGE", "User Story development time estimated Successfully !");
		} else {
			view = "estimateDeveloperUserStory";
		}
		return view;
	}
	
	@ModelAttribute("developerUserStoriesEstimated")
	public List<UserStory> getAllEstimatedUserStories(Employee developer, Model model, Principal principal){
		
		Employee e = ihrSubSystem.getEmployeeByUsername(principal.getName());
		
		List<UserStory> estimatedUserStories = userStoryService.getAllEstimatedDeveloperUserStories(e);
		
		if(estimatedUserStories.isEmpty()){
			model.addAttribute("EMPTY_LIST_ESTIMATED", "You don't have user stories in progress!");
		}
		return estimatedUserStories;
	}
	
	@RequestMapping(value="/developerEstimatedUserStoryList", method=RequestMethod.GET)
	public String estimatedUserStoryList(){
		return "developerEstimatedUserStoryList";
	}
	
	@RequestMapping(value="/addDeveloperWorklog", method=RequestMethod.GET)
	public String newWorklog(@RequestParam Long userStoryId, Model model){
		model.addAttribute("developerUserStoryWorklog", userStoryService.getUserStoryById(userStoryId));
		model.addAttribute("developerNewWorklog", new WorkLog());
		return "developerNewWorklog";
	}
	
	@RequestMapping(value="/addDeveloperWorklog", method=RequestMethod.POST)
	public String addWorklog(@ModelAttribute("developerUserStoryWorklog") UserStory developerUserStoryWorklog, @Valid @ModelAttribute("developerNewWorklog") WorkLog developerNewWorklog,BindingResult result, final RedirectAttributes redirectAttributes){
		String view = "redirect:/developerEstimatedUserStoryList";
		if (!result.hasErrors()) {
			UserStory u =userStoryService.getUserStoryById(developerUserStoryWorklog.getUserStoryId());
			u.addWorkLog(developerNewWorklog);
			userStoryService.saveUserStory(u);
			redirectAttributes.addFlashAttribute("SUCCESS_MESSAGE", "Worklog was added Successfully !");
		} else {
			view = "developerNewWorklog";
		}
		return view;
	}
}
