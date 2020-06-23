package com.example.services;

import java.util.List;

import com.example.entity.Activity;

public interface ActivityService {
	List<Activity> getAllActivity();
	
	Activity save(Activity activity);
		
	Activity updateActivity(Activity activity);

}
