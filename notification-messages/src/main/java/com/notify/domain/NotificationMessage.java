package com.notify.domain;

public class NotificationMessage {
	
	private Headers headers;
	
	private String body;

	public Headers getHeaders() {
		return headers;
	}

	public void setHeaders(Headers headers) {
		this.headers = headers;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "NotificationMessage [headers=" + headers + ", body=" + body + "]";
	}
	
	
	
}
