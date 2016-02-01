package edu.mum.scrum.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.scrum.domain.ReleaseBacklog;
import edu.mum.scrum.domain.Sprint;
import edu.mum.scrum.domain.UserStory;
import edu.mum.scrum.service.ReleaseService;
import edu.mum.scrum.service.SprintService;

@Controller
public class SprintController {
	
	@Autowired
	SprintService sprintService;
	
	@Autowired
	ReleaseService releaseService;
	
	@RequestMapping(value="/createSprint" ,method=RequestMethod.GET)
	public String createSprint(@ModelAttribute("sprint") Sprint sprint){
		
		return "sprint";
		
	}
	
	@RequestMapping(value="/createSprint", method=RequestMethod.POST)
	public String saveSprint(@ModelAttribute("sprint") Sprint sprint ,RedirectAttributes redirectAttributes){
		
		/*List <Sprint> sprints=sprintService.getAllSprints();
		
		if(sprints.isEmpty()){
			sprintService.saveSprint(sprint);
			redirectAttributes.addFlashAttribute("success" ,"Sprint Succesfully Created");
		}
		else{
		for(Sprint s:sprints){
			if(s.getSprintName().equals(sprint.getSprintName())){
				redirectAttributes.addFlashAttribute("success" ,"Sprint with this name already exists!!!");
			}
			else{
				sprintService.saveSprint(sprint);
				redirectAttributes.addFlashAttribute("success" ,"Sprint Succesfully Created");
			}
		}
		}*/
		sprintService.saveSprint(sprint);
		 return "redirect:/viewSprint";
	}
	
	@RequestMapping(value="/viewSprint", method=RequestMethod.GET)
	public String getAllSprint(Model model) {
		model.addAttribute("sprints",sprintService.getAllSprints());
		return "sprintList";
	}
	
	@RequestMapping(value = "/editSprint", method=RequestMethod.GET)
	public String editUserStory(Sprint sprint ,Model model,@RequestParam("id") Long id) {
		
		model.addAttribute("sprint",sprintService.getSprintById(id) );
		
		return "sprint";
	}
	
	/*@RequestMapping(value="/searchSprint",method=RequestMethod.GET)
	public String searchSprint(@RequestParam("name") String name,Model model){
		model.addAttribute("sprints",sprintService.searchSprintByName(name) );
		return "sprintList";
	}*/
	


}
