package com.notify.service;

import java.util.Optional;
import java.util.stream.Stream;

import com.notify.model.Message;

public interface NotificationQueryService {

	public Optional<Message> getById(String id);
	
	public Stream<Message> getMessagesBySourceApplicationId(String sourceApplicationId);
}
