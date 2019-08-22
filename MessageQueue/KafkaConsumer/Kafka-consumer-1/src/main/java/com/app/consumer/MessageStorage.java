package com.app.consumer;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MessageStorage {

	
	private List<String> list= new LinkedList<>();
	
	public void add(String msg)
	{
		list.add(msg);
	}
	
	
	public void all()
	{
		list.forEach(System.out::println);   // print messages in list on call
	}
	
}
