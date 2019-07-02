package com.app.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

import com.app.util.EmailUtil;

@Component
public class MailRunner implements CommandLineRunner{

	@Autowired
	private EmailUtil util;

	@Override
	public void run(String... args) throws Exception {
			
	//boolean flag =util.send("saurabh.vaish1993@gmail.com", "hello from app","successfully send from boot app without file", null);

	FileSystemResource file = new FileSystemResource("C:\\Users\\The_Incredible_Srv\\Pictures\\Saved Pictures\\windows_11.jpg");
		
	boolean flag =util.send("saurabh.vaish1993@gmail.com", "hello from app","successfully send from boot app with file", file);
		
	if(flag) System.out.println("done");
	else System.out.println("check error");
	
	}
	
	
	
	
}
