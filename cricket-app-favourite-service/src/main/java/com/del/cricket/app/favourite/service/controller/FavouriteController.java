package com.del.cricket.app.favourite.service.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.del.cricket.app.favourite.service.Repo.FavouriteRepo;
import com.del.cricket.app.favourite.service.model.Favourite;
import com.del.cricket.app.favourite.service.model.Player;
import com.del.cricket.app.favourite.service.pojo.idFormatter;
import com.del.cricket.app.favourite.service.services.FavouriteServiceInterface;


@RestController
@RequestMapping("/favourite")
public class FavouriteController {
	
	@Autowired
	private FavouriteServiceInterface favouriteServiceInterface;
	
	@Value("${player_url}")
	private String playerwalaurl;
	
	
	@GetMapping("")
	public ResponseEntity<Object> getFavourites(){
		List<Favourite> lFavourites = favouriteServiceInterface.getFavourites();
		
		RestTemplate rt = new RestTemplate();
		ArrayList<Player> pl = new ArrayList<Player>();
		lFavourites.stream().forEach(e -> pl.add( rt.getForObject(playerwalaurl+e.getId(), Player.class)));
		
		
		
		try {
            return com.del.cricket.app.favourite.service.Response.ResponseHandler.generateResponse("Successfully fetched data!", HttpStatus.OK,pl);
        } catch (Exception e) {
            return com.del.cricket.app.favourite.service.Response.ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);

        }
	}
	
	@PostMapping("/add")
	public ResponseEntity<Object> addFavourite(@RequestBody idFormatter id){
		
		try {
			favouriteServiceInterface.addFavourite(id.getId());
            return com.del.cricket.app.favourite.service.Response.ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK,"lol");
        } catch (Exception e) {
            return com.del.cricket.app.favourite.service.Response.ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);

        }
		
	}
	
	
	
}
