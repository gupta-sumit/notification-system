package com.notify.event.handler.kafka;

import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;

import event.api.Event;
import event.api.handler.EventHandler;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class KafkaEventHandler implements EventHandler {

	private static final Logger logger = LoggerFactory.getLogger(KafkaEventHandler.class);
	private final @NonNull String topic;
	private final @NonNull KafkaTemplate<String, Event<?>> kafkaTemplate;
	private @NonNull Function<Event<?>, String> keyCreatorFunction = defaultKeyFunction();
	
	private static Function<Event<?>, String> defaultKeyFunction() {
		return (e) -> e.getId();
	}

	@Override
	public void handleEvent(Event<?> event) {
		Objects.requireNonNull(event);
		Objects.requireNonNull(event.getType());
		logger.info("Processing event {}", event);
		String key = keyCreatorFunction.apply(event);
		logger.debug("Created key for event [{}], key [{}]", event, key);
		ListenableFuture<SendResult<String, Event<?>>> future = kafkaTemplate.send(topic,key, event);
		try {
			SendResult<String, Event<?>> sendResult = future.get();
			logger.info("Event sent to kafka topic {} , message sent result {}", topic, sendResult);
		} catch (InterruptedException | ExecutionException e) {
			throw new SendMessageException("Exception occurred while sending message to kafka ", e);
		}
	}
	
}
