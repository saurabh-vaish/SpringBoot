package com.app.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

/***
 * 
 * 	ItemReader is used to read data from source like file object etc .
 * 	It is used in step creation . 
 * 	
 * 		It implements ItemReader (I) having read() .  It takes generic T that can be string object or collection and must be same
 * 														as Process input generic type
 * 
 * ***/


public class Reader implements ItemReader<String>{

	// providing data for reader 
	
	String [] ar = {"hello","welcome","to","batch"};
	int count =0;
	
	@Override
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		
		System.out.println("item reader ");
		
		if(count<ar.length)
		{
			return ar[count++];
		}
		else {
			count =0;
		}
		
		return null;
	}

}
