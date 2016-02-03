package edu.mum.scrum.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.scrum.domain.ReleaseBacklog;
import edu.mum.scrum.domain.UserStory;
import edu.mum.scrum.hr.IHRSubSystem;
import edu.mum.scrum.service.ReleaseService;
import edu.mum.scrum.service.SprintService;
import edu.mum.scrum.service.UserStoryService;

@Controller
public class UserStoryController {
	@Autowired
	UserStoryService userStoryService;
	@Autowired
	ReleaseService releaseService;
	@Autowired
	IHRSubSystem subSystemFacade;
	@Autowired
	SprintService sprintService;
	
	/*display User Story form  */
	
	@RequestMapping(value="/createUserStory" ,method=RequestMethod.GET)
	public String createUserStory(@ModelAttribute("userStory") UserStory userStory){
		
		return "userStory";	
	}
	
	/* save User Story form */
	
	@RequestMapping(value="/createUserStory", method=RequestMethod.POST)
	public String saveUserStory(@Valid @ModelAttribute("userStory") UserStory userStory ,BindingResult result
			,@RequestParam("userStoryId") Long id,Model model){
		
		if(result.hasErrors()){
			return "userStory";
		}	
		
			if(id == null && !userStoryService.checkUserStoryName(userStory.getName())){
				model.addAttribute("exist", "User Story Name already Exists");
	      	return "userStory";
			}
			
		ReleaseBacklog release =releaseService.getReleaseById(1);
		userStory.setRelease(release);
		
		if (id!= null){
			UserStory userStory1 = userStoryService.getUserStoryById(id);
			userStory.setSprint(userStory1.getSprint());
			userStory.setAssignedDev(userStory1.getAssignedDev());
			userStory.setAssignedTes(userStory1.getAssignedTes());
		}
		
		
		userStoryService.saveUserStory(userStory);
			
		return "redirect:/viewUserStory";
	}
	
	/* edit User Story*/
	
	@RequestMapping(value = "/editUserStory", method=RequestMethod.GET)
	public String editUserStory(UserStory userStory ,Model model,@RequestParam("id") Long id) {
		
		model.addAttribute("userStory", userStoryService.getUserStoryById(id));
		
		return "userStory";
	}
	
	/*delete User Story*/
	
	@RequestMapping(value = "/deleteUserStory", method=RequestMethod.GET)
	public String deleteUserStory(UserStory userStory ,Model model,@RequestParam("id") Long id) {
		
		userStoryService.deleteUserStoryById(id);
		return "redirect:/viewUserStory";
	}
	
	/* display list of User Stories*/
	
	@RequestMapping(value = "/viewUserStory", method=RequestMethod.GET)
	public String viewUserStory(Model model) {
		
		model.addAttribute("userStories", userStoryService.getAllUserStories());
		
		return "userStoryList";
	}
	
	/*display User Story Assign form*/
	
	@RequestMapping(value="/assignUserStory" ,method=RequestMethod.GET)
	public String assignUserStory(@ModelAttribute("userStory")UserStory userStory , @RequestParam("id") Long id ,Model model){
		
		model.addAttribute("userStory",userStoryService.getUserStoryById(id));
		model.addAttribute("developers",subSystemFacade.getAvailableDev());
		model.addAttribute("testers",subSystemFacade.getAvailableTesters());
		
		return "assignUs";
		
	}
     /* save assigned developer and tester*/
	
	@RequestMapping(value="/assignUserStory" ,method=RequestMethod.POST)
	public String saveAssignUserStory(@RequestParam("id") Long id,@RequestParam("developer") String devName,
			@RequestParam("tester") String testName,Model model){
		
		UserStory userStory = userStoryService.getUserStoryById(id);
		if (!devName.equals("NONE")){
		userStory.setAssignedDev(subSystemFacade.getEmployeeByName(devName));
		}
		if (!testName.equals("NONE")){
		userStory.setAssignedTes(subSystemFacade.getEmployeeByName(testName));
		}
		userStoryService.saveUserStory(userStory);
		
		return "redirect:/viewUserStory";
	}
	
	/*display User Stories not added to sprint*/
	@RequestMapping(value="/addToSprint" ,method=RequestMethod.GET)
	public String addToSprint(@ModelAttribute("userStory")UserStory userStory,Model model){
		
		model.addAttribute("userStories",userStoryService.getAllUserStoryByReleaseId(1));
		model.addAttribute("sprints",sprintService.getAllSprints());
		
		if (userStoryService.getAllUserStoryByReleaseId(1).isEmpty()){
			model.addAttribute("emptyUS","No User Stories in Release");
		}
		
		return "usToSprint";
		
	}
	
	/*save a User Story added to Sprint*/
	
	@RequestMapping(value="/addToSprint" ,method=RequestMethod.POST)
	public String saveAddToSprint(@RequestParam("id") Long id,@RequestParam("sprint") String sprintName ,Model model){
		
	       userStoryService.saveUserStoryById(id ,sprintName);
		
		return "redirect:/addToSprint";
		
	}
	
}