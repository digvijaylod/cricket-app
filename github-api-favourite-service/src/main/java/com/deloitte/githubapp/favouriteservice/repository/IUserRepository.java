package com.deloitte.githubapp.favouriteservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.deloitte.githubapp.favouriteservice.model.User;

public interface IUserRepository extends JpaRepository<User, Long>{
	
	@Query("from User where username=:username")
	public User searchByUsername(@Param("username") String username);
}
