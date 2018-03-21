package com.notify.receiver.email.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

public class EmailMessageListener {
	
	private static final Logger logger = LoggerFactory.getLogger(EmailMessageListener.class);
	
	private static final String EMAIL_RECEIVER = "email-receiver";
	
	@KafkaListener(id=EMAIL_RECEIVER, groupId="hello-world",
			topics="email-topic"
			,clientIdPrefix="email-")
	public void onMessage(String message) {
		logger.info("Email message received : {}", message);
	}
	
}
