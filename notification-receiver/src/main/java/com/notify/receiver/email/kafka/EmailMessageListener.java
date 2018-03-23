package com.notify.receiver.email.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import com.notify.domain.NotificationMessage;

@Component
public class EmailMessageListener {
	
	private static final Logger logger = LoggerFactory.getLogger(EmailMessageListener.class);
	
	@Autowired
	private MailSender mailSender;
	
	private static final String EMAIL_RECEIVER = "email-receiver";
	
	@KafkaListener(id=EMAIL_RECEIVER, groupId="hello-world",
			topics="email-topic"
			,clientIdPrefix="email-")
	public void onMessage(NotificationMessage message) {
		logger.info("Email message received : {}", message);
		// validate email headers
		mailSender.send(prepareMessage(message));
	}
	
	private SimpleMailMessage prepareMessage(NotificationMessage message) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom(message.getHeaders().getFrom());
		mailMessage.setTo(message.getHeaders().getTo());
		mailMessage.setSubject(message.getHeaders().getSubject());
		mailMessage.setText(message.getBody());
		return mailMessage;
	}
	
}
