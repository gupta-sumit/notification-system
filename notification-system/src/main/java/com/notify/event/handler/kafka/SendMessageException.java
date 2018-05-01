package com.notify.event.handler.kafka;

public class SendMessageException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SendMessageException() {
		super();
	}

	public SendMessageException(String message, Throwable cause) {
		super(message, cause);
	}

	public SendMessageException(String message) {
		super(message);
	}

	public SendMessageException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	

}
