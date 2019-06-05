package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// starting point of application 


@SpringBootApplication			// consist of @Component ,@Configuration ...
public class MyStarter {

	public static void main(String[] args) {

		SpringApplication.run(MyStarter.class, args);      
	}

}
