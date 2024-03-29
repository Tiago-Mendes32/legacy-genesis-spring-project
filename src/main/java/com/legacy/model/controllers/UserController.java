package com.legacy.model.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.legacy.model.entities.User;
import com.legacy.model.entities.DTO.UserDTO;
import com.legacy.model.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping("/dto")
	public List<UserDTO> findAllDTO() {
		List<User> list = service.findAll();
		List<UserDTO> listDTO = service.getUserDTOList(list);
		return listDTO;
	}
	
	@GetMapping("/dto/{id}")
	public UserDTO findByIdDTO(@PathVariable String id) throws Exception {
		 User obj = service.findById(id);
		 return service.getUserDTO(obj);
	}
	
	@GetMapping
	public List<User> findAll() {
		List<User> list = service.findAll();
		return list;
	}
	
	@GetMapping("/{id}")
	public User findById(@PathVariable String id) throws Exception {
		return service.findById(id);
	}
	
	@GetMapping("/doc/{doc}")
	public User findByDocument(@PathVariable String doc) throws Exception {
		return service.findByDocument(doc);
	}
	
	@PostMapping
	public UserDTO insert(@RequestBody User obj) throws Exception{
		User newObj = service.insert(obj);
		return service.getUserDTO(newObj);
	}
	
	@PutMapping
	public User update(User obj, String id) throws Exception {
		return service.update(obj, id);
	}
	
	@DeleteMapping
	public void delete(String id) throws Exception {
		service.deleteById(id);
	}
}
