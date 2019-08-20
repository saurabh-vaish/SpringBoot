package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class ActiveMqPubSubConsumer2Application {

	public static void main(String[] args) {
		SpringApplication.run(ActiveMqPubSubConsumer2Application.class, args);
	}

}
