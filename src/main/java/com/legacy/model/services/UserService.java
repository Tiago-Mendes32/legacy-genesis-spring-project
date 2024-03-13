package com.legacy.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.legacy.config.mappers.UserMapper;
import com.legacy.model.entities.User;
import com.legacy.model.entities.DTO.UserDTO;
import com.legacy.model.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	@Autowired
	private UserMapper userMapper;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(String id) throws Exception {
		return repository.findById(id).orElseThrow(() -> new Exception("Entity not found"));
	}

	public User findByDocument(String doc) {
		return repository.findByDocument(doc);
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

	public User update(User obj, String id) throws Exception {
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

	public UserDTO getUserDTOById(String userId) throws Exception {
		User user = findById(userId);
		return userMapper.userToUserDTO(user);
	}

	public List<UserDTO> getUserDTOList(List<User> list) {
		return userMapper.usersToUserDTOs(list);
	}

}
