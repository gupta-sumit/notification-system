package com.notify.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@JsonTypeInfo(use=Id.NAME,include=As.PROPERTY,property="messageType",visible=true)
@JsonSubTypes({
	@Type(value = EmailMessagePayload.class, name = "EMAIL")
})
public abstract class MessagePayload {
	
	private MessagePayloadType messageType;

	public MessagePayloadType getMessageType() {
		return messageType;
	}

	public void setMessageType(MessagePayloadType messageType) {
		this.messageType = messageType;
	}

}
