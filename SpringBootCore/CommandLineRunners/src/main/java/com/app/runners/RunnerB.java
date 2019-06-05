package com.app.runners;


import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
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
public class RunnerB implements CommandLineRunner, Ordered{

	@Override
	public void run(String... args) throws Exception {

		System.out.println("from runner - B");
	}

	@Override
	public int getOrder() {
		return 5;
	}

	
	
	
}
