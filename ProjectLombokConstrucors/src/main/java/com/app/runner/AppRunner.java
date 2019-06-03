package com.app.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.model.Project;

@Component
public class AppRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {

		Project p = new Project();
		p.setPId(10);
		p.setPName("abc");
		p.setPCost(3.3);
		System.out.println(p);
		
		Project p2 = new Project(11,"XYZ");   // calling parameterized constructors
		System.out.println(p2);
		
		
	}

}
