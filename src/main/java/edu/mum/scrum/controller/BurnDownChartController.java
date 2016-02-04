
package edu.mum.scrum.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.mum.scrum.domain.Sprint;
import edu.mum.scrum.domain.UserStory;
import edu.mum.scrum.domain.WorkLog;
import edu.mum.scrum.service.SprintService;
import edu.mum.scrum.service.UserStoryService;

@Controller
public class BurnDownChartController {
	
	@Autowired
	private UserStoryService userStoryService;
	@Autowired
	private SprintService sprintService;
	
	private static int sprintDuration = 0;
	private String originalETC = "";
	private String remainingETC = "";
	
	@RequestMapping(value =  "/ViewBurnDownChart", method = RequestMethod.GET)
	public String viewBurnDown(@RequestParam("sprintID") Long sprintID, Model model) {
		String trend = "";
		String sprintName = "";
		String days = "";
		
		sprintDuration = 0;
		originalETC = "[";
		remainingETC = "[";
		
		Sprint sprint = sprintService.getSprintById(sprintID);
		
		List<UserStory> l = sprint.getUserStories();
		
		Set<UserStory> lstUserStory = new HashSet<>();
		for (UserStory userStory : l) {
			System.out.println(userStory.getUserStoryId());
			lstUserStory.add(userStory);
		}
		Set<WorkLog> USHistories = getUserStoryHistory(lstUserStory);
		System.out.println(l.size() + "-----" + lstUserStory.size() + "----" + USHistories.size());
		days = buildXAxisAndOriginalETC(sprint.getStartDate(), sprint.getEndDate(), lstUserStory, USHistories);
		
		sprintName = sprint.getSprintName();
		
		boolean controlSprintName = false;
		if (sprint.getStartDate().after(Calendar.getInstance().getTime())) {
			sprintName += " not start yet.";
			controlSprintName = true;
		}
		if (lstUserStory.size() == 0  && !controlSprintName) {
			sprintName += ": No User Story.";
		}
		
		// sprintDuration is calculated in buildXAxis()
		// Chart start from 0 hence we have to decrease 1
		sprintDuration -= 1;
	
		// Build trend
		trend = buildTrendSerial(lstUserStory, sprint.getStartDate());
		
		model.addAttribute("Trend", trend);
		model.addAttribute("OriginalETC", originalETC);
		model.addAttribute("RemainingTime", remainingETC);
		model.addAttribute("DaysXAxis", days);
		model.addAttribute("SprintName", sprintName);
		
		return "BDC";
	}
	
	private Set<WorkLog> getUserStoryHistory(Set<UserStory> userStories ) {
		Set<WorkLog> usHistories = new HashSet<WorkLog>();
		
		for (UserStory us : userStories) {
			Set<WorkLog> temp = us.getWorkLog();
			usHistories.addAll(temp);
		}
		
		return usHistories;
	}
	
	private String buildTrendSerial(Set<UserStory> userStories, Date startDate) {
		String trend = "[";
		
		if (userStories.size() > 0 && startDate.before(Calendar.getInstance().getTime())) {
			try {
				double totalOriginalETC = 0;
				double burnDownHour = 0;
				
				// Calculate total original estimation
				for (UserStory userStory : userStories) {
					totalOriginalETC += userStory.getDevEstimate();
				}
				
				burnDownHour = totalOriginalETC / sprintDuration;
				burnDownHour = Math.round(burnDownHour);
				int tempDuration = sprintDuration;
				
				while (tempDuration > 0) {
					trend += String.valueOf(totalOriginalETC) + ",";
					// burn hour for next day
					totalOriginalETC -= burnDownHour;
					
					tempDuration--;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			trend += "0]";
		} else 
			trend += "]";
		
		return trend;
	}
	
	private String getDate(String date) {
		return date.substring(0, 10) + ", " + date.substring(date.length() - 4, date.length());
	}
	
	private String getOriginalETCAtDate(Set<UserStory> userStories, Calendar startCal) {
		double ETC = 0;
		Calendar usCal = Calendar.getInstance();
		
		for (UserStory us : userStories) {
			usCal.setTime(us.getDateAddedToSprint());
			if (usCal.getTimeInMillis() <= startCal.getTimeInMillis())
				ETC += us.getDevEstimate();
		}
		
		return String.valueOf(ETC);
	}
	
	private double getRemainingTimePerUserStory(List<WorkLog> USHistories, Calendar startCal) {
		Date minDate = USHistories.get(0).getTime();
		int minIndex = 0;
		
		System.out.println(startCal.getTime().toString());
		for (int i = 0; i < USHistories.size(); i++) {
			System.out.println(USHistories.get(i).getTime().toString());
			if (USHistories.get(i).getTime().compareTo(startCal.getTime()) == 0) {
				// startCal is equal to Jan 26, 28 or 29
				return USHistories.get(i).getRemainingHours();
			}
			
			// Find min date, it is equal to original estimation
			if (USHistories.get(i).getTime().before(minDate)) {
				minDate = USHistories.get(i).getTime();
				minIndex = i;
			}
		}
		
		// We are here in 2 cases, let say the USHistories has: Jan 26, Jan 28 and Jan 29 
		if (startCal.before(minDate)) {
			// startCal is equal to Jan 25, then we do not need to count remaining time for this US
			return 0.0;
		} else {
			// startCal is equal to Jan 27
			return USHistories.get(minIndex).getRemainingHours();
		}
	}
	
	private String getRemainingTimeAtSpecificDate(Set<UserStory> userStories, Calendar startCal) {
		double ret = 0.0;
		
		for (UserStory us : userStories) {
			Set<WorkLog> usHist = us.getWorkLog();
			List<WorkLog> w = new ArrayList<>();
			for (WorkLog workLog : usHist) {
				w.add(workLog);
			}
//			for (WorkLog usHistory : USHistories) {
////				 build list history of specific user story
//				if (usHistory.getUserstory().getId() == us.getId())
//					usHist.add(usHistory);
//			}
			
			ret += getRemainingTimePerUserStory(w, startCal);
		}
		
		return String.valueOf(ret);
	}
	
	private String buildXAxisAndOriginalETC(Date startDate, Date endDate, 
											Set<UserStory> userStories, Set<WorkLog> USHistories) {
	    Calendar startCal;
	    Calendar endCal;
	    
	    startCal = Calendar.getInstance();
	    startCal.setTime(startDate);
	    
	    endCal = Calendar.getInstance();
	    endCal.setTime(endDate);
	    
	    String workDays = "";
		ObjectMapper mapper = new ObjectMapper();
		List<String> arrString = new ArrayList<String>();
	    
	    do {
	        
	        if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY 
	        		&& startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
	        	arrString.add(getDate(startCal.getTime().toString()));
	            sprintDuration++;
	            
	            if (userStories.size() > 0 && startDate.before(Calendar.getInstance().getTime())) {
			        // Build Original ETC
		            originalETC += getOriginalETCAtDate(userStories, startCal) + ",";
		            
		            // Build remaining Time
		            // No need to calculate if it not time yet
		            if (startCal.getTimeInMillis() < Calendar.getInstance().getTimeInMillis())
		            	remainingETC += getRemainingTimeAtSpecificDate(userStories, startCal) + ",";
	            }
	        }
	        
	        startCal.add(Calendar.DAY_OF_MONTH, 1);
	    } while (startCal.getTimeInMillis() <= endCal.getTimeInMillis());
	    
	    if (userStories.size() > 0 && startDate.before(Calendar.getInstance().getTime())) {
	        originalETC = originalETC.substring(0, originalETC.length() - 1) + "]";
	        remainingETC = remainingETC.substring(0, remainingETC.length() - 1) + "]";
	    } else {
	    	originalETC += "]";
	    	remainingETC += "]";
	    }

        try {
			workDays = mapper.writeValueAsString(arrString);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

	    return workDays; 
	}
	
	
//	.......................................................................................
//	
//	@RequestMapping(value="/ViewBurnDownChart",method=RequestMethod.GET)
//	public String generateBDC(@RequestParam("id") Long id,Model model){
//		
//        model.addAttribute("SprintName", sprintService.getSprintById(id).getSprintName());
//        System.out.println("sprintService.getSprintById(id).getSprintName()");
//		
//		String trend = "[7.0, 6.9, 9.5, 5.7, 7.9]";
//		String originalETC = "[-0.2, 0.8, 5.7]";
//		String remainingETC = "[-0.9, 0.6, 3.5]";
//		String days = "[\"Feb 12\", \"Feb 11\", \"Feb 14\", \"Feb 11\",\"Feb 15\"]";
//		
//		model.addAttribute("Trend", trend);
//		model.addAttribute("OriginalETC", originalETC);
//		model.addAttribute("RemainingTime", remainingETC);
//		model.addAttribute("DaysXAxis", days);
//		
//		return "BDC";
//		
//		
//	}

}
