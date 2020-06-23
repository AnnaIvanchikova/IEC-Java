package com.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.example.entity.Activity;
import com.example.repository.ActivityRepository;

@Service
public class ActivityServiceImpl implements ActivityService{
	
	@Autowired
	private ActivityRepository activityRepository;

	@Override
	public List<Activity> getAllActivity() {
		// TODO Auto-generated method stub
		return activityRepository.findAll();
	}

	@Override
	public Activity save(Activity activity) {
		// TODO Auto-generated method stub
		return activityRepository.save(activity);
	}

	
	public Activity updateActivity(Activity activity) {
		Optional<Activity> activityDB = activityRepository.findById(activity.getId().toString());
		if(activityDB.isPresent()) {
			Activity activityUpdate = activityDB.get();
			activityUpdate.setId(activity.getId());
			activityUpdate.setDescription(activity.getDescription());
			activityUpdate.setEndDateTime(activity.getEndDateTime());
			activityUpdate.setInfo(activity.getInfo());
			activityUpdate.setStartDateTime(activity.getStartDateTime());
			activityUpdate.setSummary(activity.getSummary());
			activityUpdate.setTitle(activity.getTitle());
			activityRepository.save(activityUpdate);
			return activityUpdate;
		}
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
