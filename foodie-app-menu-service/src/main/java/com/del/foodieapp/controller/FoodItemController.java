package com.del.foodieapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.del.foodieapp.model.FoodItem;
import com.del.foodieapp.model.Recipe;
import com.del.foodieapp.service.IFoodItemService;

@RestController
@RequestMapping("/menu")
public class FoodItemController 
{
	@Autowired
	private IFoodItemService service;
	
	@GetMapping("/items/{itemCode}")
	public FoodItem getFoodItem(@PathVariable long itemCode)
	{
		FoodItem item = service.getFoodItem(itemCode);
		Recipe recipe = service.getRecipe(item.getItemName());
		item.setRecipe(recipe);
		return item;
	}
	
	@PostMapping("/items")
	public FoodItem addFoodItem (@RequestBody FoodItem item) {
		return service.addFoodItem(item);
	}
	
	@GetMapping("/items")
	public List<FoodItem> getAllFoodItem()
	{
		return service.getAllFoodItem();
	}

	@DeleteMapping("/items/{item-code}")
	public boolean deleteFoodItem(@PathVariable("item-code") long itemCode)
	{
		return service.deleteFoodItem(itemCode);
	}
	
	@PutMapping("/items")
	public FoodItem updateFoodItem(@RequestBody FoodItem item)
	{
		return service.updateFoodItem(item);
	}
	
	@GetMapping("/items/items-name/{itemName}")
	public FoodItem getFoodItem(@PathVariable String itemName)
	{
		return service.getFoodItemByName(itemName);
	}
	
//	@GetMapping("/items/{item-name}")
//	public FoodItem getRecipe(@PathVariable("item-name") String itemName)
//	{
//		return service.getFoodItemByName(itemName);
//				
//	}	
	
}
