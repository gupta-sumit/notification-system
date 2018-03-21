package com.notify.receiver;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

@ConfigurationProperties(prefix="app.kafka")
@Configuration
public class KafkaConsumerConfig {

	private static final int DEFAULT_MESSAGE_POLL_TIMEOUT = 3000;
	
	private String bootstrapServers;
	private int messagePollTimeout = DEFAULT_MESSAGE_POLL_TIMEOUT;

	
	@Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<Integer, String>>
                        kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<Integer, String> factory =
                                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(kafkaConsumerFactory());
        factory.setConcurrency(3);
        factory.getContainerProperties().setPollTimeout(messagePollTimeout);
        return factory;
    }

	@Bean
    public ConsumerFactory<Integer, String> kafkaConsumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfigs());
    }
	
	@Bean
    public Map<String, Object> consumerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
       // ...
        return props;
    }
	
	
	
	public String getBootstrapServers() {
		return bootstrapServers;
	}

	public void setBootstrapServers(String bootstrapServers) {
		this.bootstrapServers = bootstrapServers;
	}

	public int getMessagePollTimeout() {
		return messagePollTimeout;
	}

	public void setMessagePollTimeout(int messagePollTimeout) {
		this.messagePollTimeout = messagePollTimeout;
	}
	
}
