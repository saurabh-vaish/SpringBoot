package com.app.reciever;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.app.message.MyMessage;

/**
 *  Pub-Sub :- Send Message from one producer to Many consumer . It store messages in destination memory called Topic .
 * 
 * 	Produces :-  It uses JmsTemplate to send message to consumer.
 * 
 * 	@EnableJms :- Use at starter class level for configuration .
 * 
 * 	@JmsListener(destination = "...") :-  use at method level to specify destination memory name .
 * 
 * 		javax.jms.Message (I) :- Root interfcae for all Jms Messages (Text and Object Both)
 * 
 * 		 Then cast it to TextMessage type for TextMessage and ObjectMessege for Serialized Object
 * 
 * 		For sending Object , the object must be serializable .
 * 
 * 		---> Object must be serialized and serialversionUid must be same .
 * 
 *  	--> In properties file specify spring.activemq.packages.trust-all  -- to trust all classes in Deserialization 
 *
 * 
 * **/




@Component
public class MyMessageReader {

	@JmsListener(destination = "my-PubSub-text")
	public void readTextMessage(Message m)					// javax.jms.Message -- root interface for all messages to recieve all type of messeges
	{
		TextMessage tm = (TextMessage) m;				// for text message
		
		try {
			String msg = tm.getText();
			
			System.out.println("From Consumer "+msg);
			
		} catch (JMSException e) {
			e.printStackTrace();
		}

		System.out.println("done text message");
		
	}
	
	
	@JmsListener(destination = "my-PubSub-object")
	public void readObjectMessage(Message m)
	{
		ObjectMessage om = (ObjectMessage) m;			// for Object that must be Serialized
		
		
		try {
			MyMessage msg = (MyMessage) om.getObject();
			
			System.out.println(msg);
			
		} catch (JMSException e) {
			e.printStackTrace();
		}
	
		System.out.println("done object message");
		
	}

	
}
