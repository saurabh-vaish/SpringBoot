package com.app.router;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;


@Component
public class MyRouter extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		//  comment others to work with others
		
	
		//1. using file system
		from("file://J:/sourceFiles")   // reading from sourceFiles folder present in F drive
		.to("file://J:/destiFiles");	// sending to destiFiles folder present in F drive
		
		
		
		
		// 2. using file system but turning off overriding programming of files

		from("file://J:/sourceFiles?noop=true")   
		.to("file://J:/destiFiles");	

		
		

		// 3. using file system but details from propeties file  i.e. dynamic location
		
		from("{{sourceFiles}}")   
		.to("{{destiFiles}}");	
		
		
		
		
		// 4. reading from project folder i.e. in current folder
		
		from("file://sourceFiles")   
		.to("file://destiFiles");	
	
		
	}

}
