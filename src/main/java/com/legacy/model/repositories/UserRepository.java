package com.legacy.model.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.legacy.model.entities.User;
@Repository
public interface UserRepository extends MongoRepository<User, String>{
	
	public User findByDocument(String doc);
}
