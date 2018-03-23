package com.notify.receiver.slack.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.notify.domain.NotificationMessage;

@Component
public class SlackMessageListener {

	private static final Logger logger = LoggerFactory.getLogger(SlackMessageListener.class);
	
	
	private static final String SLACK_RECEIVER = "slack-receiver";
	
	@KafkaListener(id=SLACK_RECEIVER, groupId="slack-world",
			topics="${slack.receiver.config.topic}"
			,clientIdPrefix="slack-")
	public void onMessage(NotificationMessage message) {
		logger.info("Email message received : {}", message);
	}
}
