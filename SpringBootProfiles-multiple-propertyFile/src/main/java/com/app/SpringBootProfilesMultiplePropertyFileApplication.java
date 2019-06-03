package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// we can use multiple properties or yml files for multiple profiles using format -  application-<profilename>.properties/yml
// if any key or file not found then default property file will be execute
// we can mention active profile using option args or in property file 


@SpringBootApplication
public class SpringBootProfilesMultiplePropertyFileApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProfilesMultiplePropertyFileApplication.class, args);
	}

}
