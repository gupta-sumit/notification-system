package com.notify.domain;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@JsonTypeInfo(use=Id.NAME,include=As.PROPERTY,property="notificationType",visible=true)
@JsonSubTypes({
	@Type(value = EmailHeaders.class, name = "EMAIL"),
	@Type(value = Headers.class, name = "SLACK"),
})
public class Headers {

	private NotificationType notificationType;
	private String from;
	private String [] to;
	private String subject;
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String[] getTo() {
		return to;
	}
	public void setTo(String[] to) {
		this.to = to;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public NotificationType getNotificationType() {
		return notificationType;
	}
	public void setNotificationType(NotificationType notificationType) {
		this.notificationType = notificationType;
	}
	@Override
	public String toString() {
		return "Headers [notificationType=" + notificationType + ", from=" + from + ", to=" + Arrays.toString(to)
				+ ", subject=" + subject + "]";
	}
	
	
}
