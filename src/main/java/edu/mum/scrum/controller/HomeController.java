package edu.mum.scrum.controller;

import org.springframework.ui.Model;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.log4j.Logger;

@Controller
public class HomeController {
	private static final Logger logger = Logger.getLogger(DeveloperController.class);
	
	@RequestMapping(value="/")
	public String home(Model model, Principal principal){
		//logs debug message
				if(logger.isDebugEnabled()){
					logger.debug("getWelcome is executed!");
				}
				
				//logs exception
				logger.error("This is Error message", new Exception("Testing"));
		return "userStoryList";
	}

}
