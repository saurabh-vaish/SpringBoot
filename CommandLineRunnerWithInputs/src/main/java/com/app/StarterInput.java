package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// starting point of application 


@SpringBootApplication			// consist of @Component ,@Configuration ...
public class StarterInput {

	public static void main(String[] args) {

		System.out.println(" from starter ");

		SpringApplication.run(StarterInput.class, args);  
	}

}
