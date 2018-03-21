package com.notify.message.sender.kafka;

import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.concurrent.ListenableFuture;

import com.notify.domain.NotificationMessage;
import com.notify.domain.NotificationType;
import com.notify.message.sender.MessageSender;

@Service
public class KafkaMessageSender implements MessageSender {

	private static final Logger logger = LoggerFactory.getLogger(KafkaMessageSender.class);
	
	@Autowired
	private KafkaTemplate<String, NotificationMessage> kafkaTemplate;
	
	@Autowired
	private Map<NotificationType, String> topicMap;
	
	@Override
	public void send(NotificationMessage message) {
		Assert.notNull(message, "message must not be null");
		Assert.notNull(message.getHeaders(), "message.getHeaders() must not be null");
		if(topicMap.containsKey(message.getHeaders().getNotificationType())) {
			String topic = topicMap.get(message.getHeaders().getNotificationType());
			ListenableFuture<SendResult<String, NotificationMessage>> future = kafkaTemplate.send(topic,createKey(message), message);
			try {
				SendResult<String, NotificationMessage> sendResult = future.get();
				logger.info("Message sent to kafka topic {} , message sent result {}", topic, sendResult);
			} catch (InterruptedException | ExecutionException e) {
				throw new SendMessageException("Exception occurred while sending message to kafka ", e);
			}
			return;
		} 
		throw new SendMessageException("Notification Type " + message.getHeaders().getNotificationType() + " not supported");
	}

	private String createKey(NotificationMessage message) {
		return message.getHeaders().getFrom();
	}
	
}
