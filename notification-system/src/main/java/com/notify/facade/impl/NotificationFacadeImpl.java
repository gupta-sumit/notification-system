package com.notify.facade.impl;

import org.springframework.stereotype.Service;

import com.notify.facade.NotificationFacade;
import com.notify.model.Message;
import com.notify.service.NotificationService;

import event.api.Event;
import event.api.dispatcher.EventDispatcher;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class NotificationFacadeImpl implements NotificationFacade {
	
	private final @NonNull NotificationService notificationService;
	
	private final @NonNull EventDispatcher eventDispatcher;
	
	@Override
	public Message createAndSendMessage(Message message) {
		Message persistedMessage = notificationService.save(message);
		log.info("Notification Message Created [{}]. Dispatching event...", persistedMessage);
		eventDispatcher.dispatchEvent(new Event<Message>(EventType.NEW_NOTIFICATION.name(), persistedMessage));
		return persistedMessage;
	}
	
}
