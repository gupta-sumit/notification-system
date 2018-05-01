package com.notify.application.config;

import java.util.Objects;
import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;

import com.notify.event.handler.kafka.KafkaEventHandler;
import com.notify.facade.impl.EventType;

import event.api.Event;
import event.api.dispatcher.EventDispatcher;
import event.api.dispatcher.impl.EventDispatchers;
import event.api.handler.EventHandlerRegistry;
import event.api.handler.impl.SimpleEventHandlerRegistry;

@Configuration
public class EventSystemConfig {

	private static final Logger logger = LoggerFactory.getLogger(EventSystemConfig.class);
	
	@Autowired
	private MessageTopicConfig topicConfig;
	
	@Bean
	public EventHandlerRegistry eventHandlerRegistry(@Autowired KafkaEventHandler kafkaEventHandler) {
		SimpleEventHandlerRegistry simpleEventHandlerRegistry = new SimpleEventHandlerRegistry();
		simpleEventHandlerRegistry.registerEventHandler(EventType.NEW_NOTIFICATION.name(), kafkaEventHandler);
		return simpleEventHandlerRegistry;
	}

	@Bean
	public KafkaEventHandler kafkaEventHandler(@Autowired KafkaTemplate<String, Event<?>> kafkaTemplate) {
		Objects.requireNonNull(topicConfig.getTopicName());
		return new KafkaEventHandler(topicConfig.getTopicName(), kafkaTemplate);
	}
	
	@Bean
	public EventDispatcher simpleEventDispatcher(@Autowired EventHandlerRegistry eventHandlerRegistry) {
		return EventDispatchers.asyncDispatcher(eventHandlerRegistry,exceptionLoggerConsumer());
	}
	
	private static Consumer<Throwable> exceptionLoggerConsumer() {
		return (t) -> {
			logger.error("Exception occured ", t);;
		};
	}
	
	
}
