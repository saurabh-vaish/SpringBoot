package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

// @Component  // no need to write as it is already present in @SBA and its object created by Spring Container automatically

// @ComponentScan("com.app")   // no need to write as starter class package works as base package and it is present in @SBA
							   // if we write it manually then it will not be added by Sping Boot
								// and starter class package will not be taken as base package

// write @ComponentScan() manually when want to add package that is not part of base package
// syntax 

@ComponentScan({"com.app","com.one.model"})


public class SpringBootStarterClassComponentScan {
		
	public static void main(String[] args) {
		
		SpringApplication sp = new SpringApplication(SpringBootStarterClassComponentScan.class);
		ConfigurableApplicationContext ac = sp.run(args);
		
		System.out.println(ac.getBean("product"));
		System.out.println(ac.getBean("customer"));
	}

}
