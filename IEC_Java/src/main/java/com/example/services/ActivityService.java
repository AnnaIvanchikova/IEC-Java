package com.example.services;

import java.util.List;
import java.util.Optional;

import com.example.entity.Activity;

public interface ActivityService {
	List<Activity> getAllActivity();
	
	Activity save(Activity activity);
		
	Activity updateActivity(Activity activity, String id);
	
	Optional<Activity> findActivityById(String id);
	
	void deleteActivity(String id);

}
