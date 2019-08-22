package com.app.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 *  For recieving messages Kafka uses @KafkaListener(topics[],groupId) 
 * 
 * 	It can reciver messages from more than one topic so topic[] 
 * 
 * 	groupId same as in property file must be unique
 * 
 * 
 * 
 * **/


@Component
public class MessageReciever {

	
	@Autowired
	private MessageStorage storage;
	
	@KafkaListener(topics = "${my-topic-name}",groupId = "groupId3")   // give same id as in property file
	public void reciver(String msg)
	{
		storage.add(msg);
		System.out.println("message from cosumer3 = "+msg);
		
		System.out.println("All messages are : ");
		
		storage.all();
	}


}
