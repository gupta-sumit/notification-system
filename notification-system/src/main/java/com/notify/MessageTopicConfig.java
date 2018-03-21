package com.notify;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.notify.domain.NotificationType;

@ConfigurationProperties(prefix="app.notification")
@Configuration
public class MessageTopicConfig {

	private Map<String, String> config;
	
	@Bean
	public Map<NotificationType, String> topicMap() {
		if(null != config && !config.isEmpty()) {
			Map<NotificationType, String> topicMap = new HashMap<>(config.size());
			for (Entry<String, String> e : config.entrySet()) {
				topicMap.put(NotificationType.valueOf(e.getKey()), e.getValue());
			}
			return topicMap;
		}
		return Collections.emptyMap();
	}

	public Map<String, String> getConfig() {
		return config;
	}

	public void setConfig(Map<String, String> config) {
		this.config = config;
	}
	
	
}
