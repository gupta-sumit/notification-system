package com.notify.service.impl;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.notify.model.Message;
import com.notify.service.NotificationQueryService;
import com.notify.service.NotificationService;
import com.notify.store.MessageStore;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
@Service
public class NotificationServiceImpl implements NotificationService, NotificationQueryService {
	
	private final @NonNull MessageStore messageStore;
	
	@Override
	public Optional<Message> getById(String id) {
		return messageStore.findById(id);
	}

	@Override
	public Message save(Message message) {
		return messageStore.save(message);
	}

	@Override
	public Stream<Message> getMessagesBySourceApplicationId(String sourceApplicationId) {
		return messageStore.findMessagesBySourceApplicationId(sourceApplicationId);
	}

}
