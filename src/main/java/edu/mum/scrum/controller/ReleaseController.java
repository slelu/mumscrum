package edu.mum.scrum.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.scrum.domain.ReleaseBacklog;
import edu.mum.scrum.service.ReleaseService;

@Controller
public class ReleaseController {
	
	@Autowired
	ReleaseService releaseService;
	
	@RequestMapping(value="/createRelease" ,method=RequestMethod.GET)
	public String createRelease(@ModelAttribute("release") ReleaseBacklog release){
		
		return "release";
		
	}
	
	@RequestMapping(value="/createRelease", method=RequestMethod.POST)
	public String saveRelease(@Valid @ModelAttribute("release") ReleaseBacklog release ,RedirectAttributes redirectAttributes,
			BindingResult result){
		if(result.hasErrors()){
			return "release";
		}
		
		releaseService.saveRelease(release);
		redirectAttributes.addFlashAttribute("success" ,"Release Succesfully Created");
		return "redirect:/viewRelease";
	}
	
	@RequestMapping(value = "/viewRelease", method=RequestMethod.GET)
	public String viewRelease(Model model) {
		
		model.addAttribute("releases", releaseService.getAllRelease());
		
		return "releaseList";
	}
}

