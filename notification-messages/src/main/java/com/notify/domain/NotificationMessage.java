package com.notify.domain;

public class NotificationMessage {
	
	private Headers headers;
	private Payload payload;

	public Headers getHeaders() {
		return headers;
	}
	public void setHeaders(Headers headers) {
		this.headers = headers;
	}
	public Payload getPayload() {
		return payload;
	}
	public void setPayload(Payload payload) {
		this.payload = payload;
	}

}
