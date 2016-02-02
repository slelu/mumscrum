/*package edu.mum.scrum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.scrum.domain.Coordinates;
import edu.mum.scrum.domain.Sprint;
import edu.mum.scrum.domain.UserStory;
import edu.mum.scrum.service.SprintService;

@Controller
public class BurnDownChartController {
	
	@Autowired
	private SprintService sprintService;
	
	
	@RequestMapping(value="/ViewBurnDownChart",method=RequestMethod.GET)
	public String generateBDC(@RequestParam("id") Long id){
		int totalEstimate=sprintService.getTotalEstimate(id);
		List <Coordinates> results=
		
		
		
	}

}*/
