package com.legacy.model.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping
	public List<UserDTO> findAll() {
		List<User> list = service.findAll();
		List<UserDTO> listDTO = service.getUserDTOList(list);
		return listDTO;
	}
	
	@GetMapping("/{id}")
	public User findById(@PathVariable String id) throws Exception {
		return service.findById(id);
	}
	
	
}
