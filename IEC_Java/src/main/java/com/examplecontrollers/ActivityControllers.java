package com.examplecontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Activity;
import com.example.services.ActivityServiceImpl;

@RestController
public class ActivityControllers {
	
	@Autowired
	private ActivityServiceImpl activityServiceImpl;
	
	@GetMapping(value = {"/getallactivities"})
	public List<Activity> getAllActivities(){
		return activityServiceImpl.getAllActivity();
	}
	
	@GetMapping(value = "/")
	public String getHello(){
		return "hello";
	}

}
