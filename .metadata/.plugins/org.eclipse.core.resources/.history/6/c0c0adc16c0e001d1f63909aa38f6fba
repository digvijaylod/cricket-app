package com.deloitte.githubapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.githubapp.model.User;
import com.deloitte.githubapp.service.IUserService;

@RestController
public class UserController {

	@Autowired
	private IUserService service;
	
	@GetMapping("/user/{user-name}")
	public User getUser(@PathVariable("user-name") String username) {
		return service.getByUsername(username);
	}
	
	@PostMapping("/user/{user-name}")
	public User addUser(@PathVariable("user-name") String username) {
		return service.saveByUsername(username);
	}
}
