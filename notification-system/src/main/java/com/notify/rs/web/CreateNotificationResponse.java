package com.notify.rs.web;

public class CreateNotificationResponse {

	private final String messageId;

	public CreateNotificationResponse(String messageId) {
		super();
		this.messageId = messageId;
	}

	public String getMessageId() {
		return messageId;
	}
}
