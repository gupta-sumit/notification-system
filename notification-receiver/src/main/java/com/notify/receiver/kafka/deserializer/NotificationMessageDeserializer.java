package com.notify.receiver.kafka.deserializer;

import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.notify.domain.NotificationMessage;

public class NotificationMessageDeserializer implements Deserializer<NotificationMessage>{

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public NotificationMessage deserialize(String topic, byte[] data) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(data, NotificationMessage.class);
		} catch (Exception e) {
			throw new MessageDeserializationException(e);
		}
	}

	@Override
	public void close() {
		
	}
	
}
