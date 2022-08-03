package com.deloitte.githubapp.favouriteservice.service;

import com.deloitte.githubapp.favouriteservice.model.User;

public interface IUserService {
	public User saveByUsername(String username);
	public User getByUsername(String username);
}
