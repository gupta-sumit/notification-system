package com.notify.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notify.domain.NotificationMessage;
import com.notify.message.sender.MessageSender;
import com.notify.service.NotificationService;

@Service
public class NotificationServiceImpl implements NotificationService{

	@Autowired
	private MessageSender messageSender;
	
	@Override
	public void validate(NotificationMessage notification) {
		
	}

	@Override
	public void send(NotificationMessage notification) {
		messageSender.send(notification);
	}

}
