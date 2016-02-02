package edu.mum.scrum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String generateBDC(/*@RequestParam("id") Long id,*/Model model){
		
		/*String originalETC = "[3.0, 3.9]";
		model.addAttribute("BDC", originalETC);*/
		
		String trend = "[7.0, 6.9, 9.5, 5.7, 7.9]";
		String originalETC = "[-0.2, 0.8, 5.7]";
		String remainingETC = "[-0.9, 0.6, 3.5]";
		String days = "[\"Feb 12\", \"Feb 11\", \"Feb 14\", \"Feb 11\",\"Feb 15\"]";
		
		model.addAttribute("Trend", trend);
		model.addAttribute("OriginalETC", originalETC);
		model.addAttribute("RemainingTime", remainingETC);
		model.addAttribute("DaysXAxis", days);
		
		return "BDC";
		
		
	}

}
