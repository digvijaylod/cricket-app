package com.deloitte.githubapp.favouriteservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.deloitte.githubapp.favouriteservice.model.User;
import com.deloitte.githubapp.favouriteservice.repository.IUserRepository;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private RestTemplate gitUserApiClient;
	
	@Value("${githubServiceApiUrl}")
	private String gitApiUrl;
	
	@Override
	public User saveByUsername(String userName) {
		System.out.println(gitApiUrl+userName);
		User user = gitUserApiClient.getForObject(gitApiUrl+userName, User.class);
		System.out.println(user);
		userRepository.save(user);
		return user;
	}

	@Override
	public User getByUsername(String username) {
		return userRepository.searchByUsername(username);
	}

}
