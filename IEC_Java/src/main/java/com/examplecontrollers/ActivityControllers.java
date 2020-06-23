package com.examplecontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Activity;
import com.example.services.ActivityServiceImpl;

@RestController
public class ActivityControllers {
	
	@Autowired
	private ActivityServiceImpl activityServiceImpl;
	
	@GetMapping(value = "/getall")
	public List<Activity> getAllActivities(){
		return activityServiceImpl.getAllActivity();
	}
	
	@PostMapping(value = "/addactivity")
	public Activity addActivity(@RequestBody Activity activity) {
	
		return activityServiceImpl.save(activity);
	}
	

}
