package com.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	
	public ResponseEntity<Activity> updateActivity(Activity activity, String id) {
		Optional<Activity> activityDB = findActivityById(id);
		if(activityDB.isPresent()) {
			Activity activityUpdate = activityDB.get();
			activityUpdate.set_id(id);
			activityUpdate.setDescription(activity.getDescription());
			activityUpdate.setEndDateTime(activity.getEndDateTime());
			activityUpdate.setInfo(activity.getInfo());
			activityUpdate.setStartDateTime(activity.getStartDateTime());
			activityUpdate.setSummary(activity.getSummary());
			activityUpdate.setTitle(activity.getTitle());
			activityRepository.save(activityUpdate);
			return new ResponseEntity<>(activityRepository.save(activityUpdate), HttpStatus.OK);
		}else {
//		// TODO Auto-generated method stub
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Optional<Activity> findActivityById(String id) {
		// TODO Auto-generated method stub
		return activityRepository.findById(id);
	}

	@Override
	public void deleteActivity(String id) {
		// TODO Auto-generated method stub
		activityRepository.deleteById(id);
	}
	
	

}
