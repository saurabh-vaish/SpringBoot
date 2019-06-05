package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* 
for giving input right click on app > Run configurations > arguments tab > provide arguments seprate by space 


--profile=dev clean start --profile=qa --db=oracle   --db=mysql  install  --model=active
*/

@SpringBootApplication
public class MyStarter {
	
	public static void main(String[] args) {
		
		SpringApplication.run(MyStarter.class, args);
		System.out.println("hii");
	}

}
