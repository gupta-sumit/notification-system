package com.notify.rs.web;

import com.notify.model.MessagePayload;

public class CreateNotificationRequest {

	private String sourceApplicationId;
	private MessagePayload message;
	
	public String getSourceApplicationId() {
		return sourceApplicationId;
	}
	public void setSourceApplicationId(String sourceApplicationId) {
		this.sourceApplicationId = sourceApplicationId;
	}
	public MessagePayload getMessage() {
		return message;
	}
	public void setMessage(MessagePayload message) {
		this.message = message;
	}
	
}
