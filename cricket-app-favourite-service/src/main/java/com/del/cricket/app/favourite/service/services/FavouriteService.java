package com.del.cricket.app.favourite.service.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.del.cricket.app.favourite.service.Repo.FavouriteRepo;
import com.del.cricket.app.favourite.service.model.Favourite;

@Service
public class FavouriteService implements FavouriteServiceInterface{

	@Autowired
	private FavouriteRepo favouriteRepo;
	

	@Override
	public List<Favourite> getFavourites() {
		return favouriteRepo.findAll();
	}

	@Override
	public void addFavourite(String id) {
		Favourite favourite = new Favourite();
		favourite.setId(id);
		favouriteRepo.save(favourite);
	}
	
	
}
