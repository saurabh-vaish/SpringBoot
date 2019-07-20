package com.app.processor;

import org.springframework.batch.item.ItemProcessor;


/***
 * 
 * 	ItemProcessor is used to process data from reader .
 * 	It is used in step creation . 
 * 	
 * 		It implements ItemProcessor (I) having process(I):O  methods .  It takes generic I that can be string object or collection and must be same
 * 			as reader generic type and O must be same as Write generic type
 * 
 * ***/


public class Processor implements ItemProcessor<String,String>
{

	@Override
	public String process(String item) throws Exception {
		
		System.out.println("processor");
		
		return "Processed :"+ item.toUpperCase();
	}

}
