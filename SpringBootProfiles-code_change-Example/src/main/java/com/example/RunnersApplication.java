package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// in this example code changes . to call different runners based on profiles use option args or property file
// for option args   --spring.profiles.active=<profile name>
// if no name given or profile not present then default profile will be called 
// if option args , property , yml all are given then first option args then property then yml will execute



@SpringBootApplication
public class RunnersApplication {

	public static void main(String[] args) {
		SpringApplication.run(RunnersApplication.class, args);
	}

}
