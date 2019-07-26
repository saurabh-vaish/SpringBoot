package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/***
 *		
 *		To enable cache management use annotation @EnableCaching in starter class 
 * 
 * 
 * */


@EnableCaching					// enable caching
@SpringBootApplication
public class SpringBootMvcCacheManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMvcCacheManagementApplication.class, args);
	}

}
