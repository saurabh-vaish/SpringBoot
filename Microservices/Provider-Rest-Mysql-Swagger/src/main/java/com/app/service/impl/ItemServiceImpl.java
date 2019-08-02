package com.app.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.exception.ItemNotFoundException;
import com.app.model.Item;
import com.app.repo.ItemRepository;
import com.app.service.IItemService;

@Service
public class ItemServiceImpl implements IItemService {


	@Autowired
	private ItemRepository repo;
	
	
	@Transactional
	public Integer saveItem(Item s) {
		return repo.save(s).getItemId();
	}


	@Transactional
	public Integer updateItem(Item s) {
		return repo.save(s).getItemId();
	}

	
	@Transactional(readOnly = true)
	public boolean isPresent(Integer id)
	{
		return repo.existsById(id);
	}
	
	
	@Transactional(readOnly = true)
	public Item getItem(Integer id) {
		Optional<Item> s= repo.findById(id);
		if(s.isPresent()) {
			return s.get();
		}
		else throw new ItemNotFoundException("No Item Found With Given Id");
	}

	
	@Transactional
	public void deleteItem(Integer id) {
		try {
			repo.deleteById(id);
		}
		catch(Exception e)
		{
			throw new ItemNotFoundException("No Item Found With Given Id");
		}
	}

	
	@Transactional(readOnly = true)
	public List<Item> getAll() {
		List<Item> list = repo.findAll();
		
		
		if(list!=null && !list.isEmpty())
		{
				// sorting Item based on codes  using collections
				/* 
				Collections.sort(list,new Comparator<Item>() {
					@Override
					public int compare(Item i1, Item i2) {
						return i1.getItemCode().compareTo(i2.getItemCode());
					}
				});
				
				*/
						
				// using streams
				return list.stream()
						.sorted((i1,i2)->i1.getItemCode().compareTo(i2.getItemCode()))	 // sorting based on codes in asc
						.collect(Collectors.toList());								    // collect as list from stream
		}
		else return list;
	}

}
