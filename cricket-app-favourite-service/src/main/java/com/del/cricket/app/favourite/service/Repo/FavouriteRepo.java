package com.del.cricket.app.favourite.service.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.del.cricket.app.favourite.service.model.Favourite;

public interface FavouriteRepo extends JpaRepository<Favourite, Integer>{
	
	

}
