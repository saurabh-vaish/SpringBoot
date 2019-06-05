package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication

// @Component  // no need to write as it is already present in @SBA and its object created by Spring Container automatically

// @ComponentScan("com.app")   // no need to write as starter class package works as base package and it is present in @SBA
							   // if we write it manually then it will not be added by Sping Boot
								// and starter class package will not be taken as base package

// write @ComponentScan() manually when want to add package that is not part of base package

// @ComponentScan({"com.app","com.one.abc"})

// AnnotationConfigApplicationContext is the container creted by starter class for non-server based applications

// AnnotationConfigServletWebServerApplicationContext  is the container for server based application

public class SpringBootStarterClass1 {

	public static void main(String[] args) {
		
		SpringApplication sp = new SpringApplication(SpringBootStarterClass1.class);
		ConfigurableApplicationContext ac = sp.run(args);
		
		System.out.println(ac.getClass().getName());
	}

}
