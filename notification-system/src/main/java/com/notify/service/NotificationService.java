package com.notify.service;

import com.notify.domain.Notification;

public interface NotificationService<T extends Notification> {

	public void validate(T notification);
	
	public void send(T notification);
}
