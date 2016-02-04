package edu.mum.scrum.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.scrum.domain.Sprint;
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
	public String saveSprint(@Valid @ModelAttribute("sprint") Sprint sprint ,BindingResult result,@RequestParam("sprintId") Long id,Model model){
		
		if(result.hasErrors()){
			return "sprint";
		}
		if(id==0&&!sprintService.checkSprintName(sprint.getSprintName())){
			model.addAttribute("exist", "Sprint Name already Exists");
      	return "sprint";
		}
		sprintService.saveSprint(sprint);
		 return "redirect:/viewSprint";
	}
	
	@RequestMapping(value="/viewSprint", method=RequestMethod.GET)
	public String getAllSprint(Model model) {
		model.addAttribute("sprints",sprintService.getAllSprints());
		return "sprintList";
	}
	
	@RequestMapping(value = "/editSprint", method=RequestMethod.GET)
	public String editUserStory(Sprint sprint ,Model model,@RequestParam("sprintId") Long id) {
		
		model.addAttribute("sprint",sprintService.getSprintById(id) );
		
		return "sprint";
	}
	
	/*@RequestMapping(value="/searchSprint",method=RequestMethod.GET)
	public String searchSprint(@RequestParam("name") String name,Model model){
		model.addAttribute("sprints",sprintService.searchSprintByName(name) );
		return "sprintList";
	}*/
	
	@InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
             SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
             dateFormat.setLenient(false);
             webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
         }

}
