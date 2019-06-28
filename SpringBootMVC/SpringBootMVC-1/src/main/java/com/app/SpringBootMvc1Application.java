package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootMvc1Application {

/**
 * Spring Boot Mvc needs starter -- spring-boot-starter-web
 * 
 * It uses auto configuration so no need to configure AppInit ,AppConfig, PropetySource , @Configuration ,@ComponentScan . It does all
 * 
 * In SpingBoot MVC , it will take care of dispatcher servlet ,handler mapper , view resolver.
 * Here base package is taken as starter files package
 * 
 * Programmer only need to work on controllers and UI ., rest of things done by spring boot
 * Programmer need to provide prefix & suffix as input .
 * 
 * In SpringBoot it have 3 embded servers --- tomacat (default) [Apache] , jetty [Eclipse] , UnderTow [JBoss]
 * 
 * Tomcat is default server runs on port 8080 , if need to change this server then use exclusion it  then add other serer
 * we can also change server-port by defining it in application.properties file
 * 
 * In spring boot tomcat considered as light weight as it works only on servlet engine (cateline) , it does not contain jasper engine for jsps.
 *
 * To work with jsp we need Jasper engine , so add jars for tomcat-embed-jasper
 * 
 * It contains to folders for resources -- static --> for .css, .js, .html ..etc , templates --> for dynamic technologies i.e. themlyfm , velocity, jsp .. etc
 *  
 *  here in Spring Boot Web continer name is --- AnnotationConfigServletWebServerApplicationContext
 * 
 * */
	

	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootMvc1Application.class, args);
	}

}
