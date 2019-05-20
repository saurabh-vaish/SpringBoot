package com.app.runners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


/* there are two runners in spring boot
 * 1. CommandLineRunner (legacy runner)
 * 2.ApplicationRunner 
 * 
 * runners are to execute java login once on starting .
 * We can hae multiple runners and they are executed according to naming convention .
 * we can also define naming using @Order(int)  or implementing Order interface .
 * 
 * */


@Component 				// bvs run method is instance method so obj needed to call it ,that will be created by spring container
@Order(10)
public class RunnerA implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {

		System.out.println("from runner - A");
	}

	
}
