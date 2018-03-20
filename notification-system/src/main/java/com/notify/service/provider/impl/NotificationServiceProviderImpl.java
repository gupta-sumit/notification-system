package com.notify.service.provider.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.notify.domain.NotificationType;
import com.notify.service.NotificationService;
import com.notify.service.provider.NotificationServiceProvider;

@Service
public class NotificationServiceProviderImpl implements NotificationServiceProvider {

	private Map<NotificationType, NotificationService<?>> notificationServiceMap;
	
	@Override
	public NotificationService<?> getNotificationService(NotificationType notificationType) {
		
		return null;
	}

}
