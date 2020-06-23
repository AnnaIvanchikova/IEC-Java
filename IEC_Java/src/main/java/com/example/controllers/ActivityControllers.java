package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Activity;
import com.example.services.ActivityServiceImpl;

@RestController
public class ActivityControllers {
	
	@Autowired
	private ActivityServiceImpl activityServiceImpl;
	
	@GetMapping(value = "/activities")
	public List<Activity> getAllActivities(){
		return activityServiceImpl.getAllActivity();
	}
	

	@PostMapping(value = "/addactivities", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
	public Activity addActivity(@RequestBody Activity activity) {
	
		return activityServiceImpl.save(activity);
	}
	
	@PutMapping("/activity/{id}")
	public Activity saveOrUpdateActivity(@RequestBody Activity activity, @PathVariable String id) {
        return activityServiceImpl.updateActivity(activity, id);
    }
	
	
	
	

}
