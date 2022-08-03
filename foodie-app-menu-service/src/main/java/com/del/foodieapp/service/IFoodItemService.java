package com.del.foodieapp.service;

import java.util.List;

import com.del.foodieapp.model.FoodItem;
import com.del.foodieapp.model.Recipe;

public interface IFoodItemService 
{
	public FoodItem getFoodItemByName(String itemName);
	public FoodItem addFoodItem(FoodItem item);
	public FoodItem getFoodItem(long itemCode);
	public FoodItem updateFoodItem(FoodItem item);
	public boolean deleteFoodItem(long itemCode);
	public List<FoodItem> getAllFoodItem();
	
	public Recipe getRecipe(String itemName);
	

}
