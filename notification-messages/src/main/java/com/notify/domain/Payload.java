package com.notify.domain;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@JsonTypeInfo(use=Id.NAME,include=As.PROPERTY,property="messageType",visible=true)
@JsonSubTypes({
	@Type(value = EmailMessagePayload.class, name = "EMAIL")
})
public interface Payload {

	public MessageType getMessageType();
}
