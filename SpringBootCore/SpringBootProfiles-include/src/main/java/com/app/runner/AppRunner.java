package com.app.runner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class AppRunner implements CommandLineRunner {

	@Value("${my.appname}")
	private String appName;
	@Value("${my.db.driver}")
	private String dbDriver;
	@Value("${my.db.url}")
	private String dbUrl;
	@Value("${my.email.host}")
	private String emailHost;
	@Value("${my.email.port}")
	private int emailPort;
	
	@Override
	public void run(String... args) throws Exception {

		System.out.println(this);
		
	}

	@Override
	public String toString() {
		return "AppRunner [appName=" + appName + ", dbDriver=" + dbDriver + ", dbUrl=" + dbUrl + ", emailHost="
				+ emailHost + ", emailPort=" + emailPort + "]";
	}

	
	

}
