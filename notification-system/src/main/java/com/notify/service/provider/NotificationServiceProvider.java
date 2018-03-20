package com.notify.service.provider;

import com.notify.domain.NotificationType;
import com.notify.service.NotificationService;

public interface NotificationServiceProvider {

	public NotificationService<?> getNotificationService(NotificationType notificationType);

}
