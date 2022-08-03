package com.del.foodieapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.del.foodieapp.model.FoodItem;
import com.del.foodieapp.model.Recipe;
import com.del.foodieapp.repository.IFoodItemRepository;

@Service
public class FoodItemServiceImpl implements IFoodItemService 
{
	@Autowired
	private IFoodItemRepository repo;
	
	@Autowired
	private RestTemplate recipeApiClient ;
	
	@Value("${recipeserviceurl}")
	private String recipeApiUrl;

	@Override
	public FoodItem addFoodItem(FoodItem item) {
		return repo.save(item);	}

	@Override
	public FoodItem getFoodItem(long itemCode) {
		return repo.findById(itemCode).get();	}

	@Override
	public FoodItem updateFoodItem(FoodItem item) {
		return repo.save(item);	}

	@Override
	public boolean deleteFoodItem(long itemCode) {
		repo.deleteById(itemCode);		
		return !repo.existsById(itemCode);
	}

	@Override
	public List<FoodItem> getAllFoodItem() {
		return repo.findAll() ;	}

	@Override
	public FoodItem getFoodItemByName(String itemName) {
		return repo.findByItemName(itemName);
	}

	@Override
	public Recipe getRecipe(String itemName) {
		return recipeApiClient.getForObject(recipeApiUrl + itemName, Recipe.class);	}

	

	

	
	

}
