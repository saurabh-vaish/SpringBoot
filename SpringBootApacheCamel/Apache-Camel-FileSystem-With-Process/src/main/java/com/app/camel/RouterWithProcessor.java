package com.app.camel;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;


/**
 * 	
 * 
 * 
 * 
 * 
 * 
 * ***/




@Component
public class RouterWithProcessor extends RouteBuilder{

	@Override
	public void configure() throws Exception {


		from("{{sourceFiles}}")

		.process( ex-> {   		// using lambda  calling processor(Exchange ex) 

				//1. Reading file using Exchange
				Message input = ex.getIn();					// returns data as Message

				//2. Reading data from Message
				String data = input.getBody(String.class);     // define msg data type

				// 3. Modifing data

				data = data + "after modified";

				// 4. Getting Output Message 

				Message output = ex.getOut();

				//5. setting data for output

				output.setBody(data);

			})
		
	    .to("file://J:/destiFiles?fileName=myData.txt");


		/*
		from("{{sourceFiles}}")

		.process(new Processor() {    		// using anonymous class

			@Override
			public void process(Exchange ex) throws Exception {

				//1. Reading file using Exchange
				Message input = ex.getIn();					// returns data as Message

				//2. Reading data from Message
				String data = input.getBody(String.class);     // define msg data type

				// 3. Modifing data

				data = data + "after modified";

				// 4. Getting Output Message 

				Message output = ex.getOut();

				//5. setting data for output

				output.setBody(data);

			}
		})

		.to("file://J:/destiFiles?fileName=myData.txt");

		*/
	}

}
