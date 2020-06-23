package com.example.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.entity.Activity;

public interface ActivityRepository extends MongoRepository<Activity, Double>{
	
	

}
