package com.notify.message.serializer;

import java.util.Map;

import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import event.api.Event;

public class JsonSerializer implements Serializer<Event<?>>{

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
		
	}

	@Override
	public byte[] serialize(String topic, Event<?> data) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(data).getBytes();
		} catch (JsonProcessingException e) {
			throw new MessageSerializationException(e);
		}
	}

	@Override
	public void close() {
		
	}
	
}
