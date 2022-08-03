package com.del.foodieapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.del.foodieapp.model.Recipe;

@Service
public class RecipeServiceImpl implements IRecipeService
{
	@Autowired
	private RestTemplate recipeApiClient ;
	
	@Value("${recipeApiUrl}")
	private String recipeApiUrl;

	@Override
	public Recipe findRecipe(String itemName) {
		return recipeApiClient.getForObject(recipeApiUrl + itemName, Recipe.class);	 
	}

}
