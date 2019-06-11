package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// example of data jpa with h2 database 
// it is a InMemoryDatabase
// its a embded database so we do not have to think about dialect , driver class name ,etc..
// database will be created at runtime and remain available untill the project is runnting 
// it uses hbm2ddll.auto = create-drop
// in this project we are using web starter also for seeing output in browser

//after running go to browser type : localhost:8080/h2-console  > change jdbc url - jdbc:h2:mem:testdb > connect

@SpringBootApplication
public class SpringBootDataJpaEmbdedH2DbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataJpaEmbdedH2DbApplication.class, args);
	}

}
