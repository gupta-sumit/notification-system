package com.notify.facade;

import com.notify.model.Message;

public interface NotificationFacade {

	public Message createAndSendMessage(Message message);
	
}
