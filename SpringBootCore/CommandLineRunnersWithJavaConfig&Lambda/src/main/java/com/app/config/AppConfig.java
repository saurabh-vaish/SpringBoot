package com.app.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// creating CommandLineRunner object by using java configuration with Anonymous Style and Lambda
// in java configuration they are executed according to thier configuration order

@Configuration
public class AppConfig {

	
	// using Anonymous Inner Type implementation for java 7 and below
	
	@Bean
	public CommandLineRunner c1()
	{
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				System.out.println("From Anonymous Inner Class");
			}
		};
	}
	
	// using Lambda Expression implementation for java 8 and below
	
	@Bean
	public CommandLineRunner c2()
	{
		return (args)->{System.out.println("from lambda ");};
		// or 
		// 	return args-> System.out.println("from lambda ") ;
	}
	
	
}
