package com.notify.rs.web;

import java.util.function.Function;

import com.notify.model.Message;

public class Mappers {

	public static Function<CreateNotificationRequest, Message> toMessage(String defaultUser) {
		return (c) -> Message.create(c.getSourceApplicationId(), c.getMessage(), defaultUser);
	}
	
	public static Function<Message, CreateNotificationResponse> toCreateNotificationResponse() {
		return (m) -> new CreateNotificationResponse(m.getId());
	}
}
