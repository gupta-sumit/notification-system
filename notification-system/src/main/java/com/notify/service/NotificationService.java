package com.notify.service;

import com.notify.domain.NotificationMessage;

public interface NotificationService {

	public void validate(NotificationMessage notification);
	
	public void send(NotificationMessage notification);
	
}
