package com.app.service;

import java.util.List;

import com.app.model.Item;

public interface IItemService {

	public Integer saveItem(Item item);

	public Integer updateItem(Item item);
	
	public Item getItem(Integer id);

	public void deleteItem(Integer id);
	
	public List<Item> getAll();
	
	boolean isPresent(Integer id);

}
