package com.legacy.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.legacy.model.entities.User;
import com.legacy.model.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(String id) throws Exception {
		return repository.findById(id).orElseThrow(()-> new Exception("Entity not found"));
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(User obj) {
		repository.delete(obj);
	}
	
	public void delete(String id) {
		repository.deleteById(id);
	}
	
	public User update(User obj,  String id) throws Exception {
		User refObj = findById(id);
		return updateData(obj, refObj);
	}

	private User updateData(User obj, User refObj) {
		refObj.setDocument(obj.getDocument());
		refObj.setEmail(obj.getEmail());
		refObj.setFirstName(obj.getFirstName());
		refObj.setLastName(obj.getLastName());
		refObj.setPassword(obj.getPassword());
		
		return refObj;
	}
	
}
