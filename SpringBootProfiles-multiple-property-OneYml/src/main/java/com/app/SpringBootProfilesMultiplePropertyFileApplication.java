package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// we can use multiple profiles in single yml file
// if any key or file not found then default property  will be execute
// we can mention active profile using option args or in yml file 


@SpringBootApplication
public class SpringBootProfilesMultiplePropertyFileApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProfilesMultiplePropertyFileApplication.class, args);
	}

}
