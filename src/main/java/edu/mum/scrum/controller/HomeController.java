package edu.mum.scrum.controller;

import org.springframework.ui.Model;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping(value="/")
	public String home(Model model, Principal principal){
		return "userStoryList";
	}

}
