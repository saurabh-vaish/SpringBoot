package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// when we have more number of keys then we can use include concept ,
// in this concept we divide single property file into multiple properties/yml files 


@SpringBootApplication
public class SpringBootProfilesInclude {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProfilesInclude.class, args);
	}

}
