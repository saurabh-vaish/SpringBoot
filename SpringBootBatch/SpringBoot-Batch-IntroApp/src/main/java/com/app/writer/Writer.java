package com.app.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

/***
 * 
 * 	ItemWriter is used to write data to destination in the form of chunks  .
 * 	It is used in step creation . 
 * 	
 * 		It implements ItemWriter (I) having write() .  It takes generic T that can be string object or collection and must be same
 * 														as Process output generic type
 * 
 * ***/


public class Writer implements ItemWriter<String>{

	@Override
	public void write(List<? extends String> items) throws Exception {
		
		System.out.println("writer executed , Data ==> "+ items);
	}

}
