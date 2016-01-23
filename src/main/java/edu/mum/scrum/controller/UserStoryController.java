/*package edu.mum.scrum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.scrum.domain.ReleaseBacklog;
import edu.mum.scrum.service.ReleaseService;

@Controller
public class UserStoryController {
	@Autowired
	ReleaseService releaseService;
	
	@RequestMapping(value="/createRelease" ,method=RequestMethod.GET)
	public String createRelease(@ModelAttribute("release") ReleaseBacklog release){
		
		return "release";
		
	}
	
	@RequestMapping(value="/createRelease", method=RequestMethod.POST)
	public String saveRelease(@ModelAttribute("release") ReleaseBacklog release ){
		releaseService.saveRelease(release);
		return "redirect:/";
	}



*/