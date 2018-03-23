package com.notify.message.sender;

import com.notify.domain.NotificationMessage;
import com.notify.message.sender.kafka.SendMessageException;

public interface MessageSender {

	public void send(NotificationMessage message) throws SendMessageException;
	
}
