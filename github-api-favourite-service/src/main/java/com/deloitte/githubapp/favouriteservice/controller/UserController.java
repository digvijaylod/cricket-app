package com.deloitte.githubapp.favouriteservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.githubapp.favouriteservice.model.User;
import com.deloitte.githubapp.favouriteservice.service.IUserService;


@RestController
public class UserController {

	@Autowired
	private IUserService service;
	
	@PostMapping("/save/{user-name}")
	public User addUser(@PathVariable("user-name") String username) {
		return service.saveByUsername(username);
	}
	
	@GetMapping("/search/{user-name}")
	public User searchUser(@PathVariable("user-name") String username) {
		return service.getByUsername(username);
	}
}
