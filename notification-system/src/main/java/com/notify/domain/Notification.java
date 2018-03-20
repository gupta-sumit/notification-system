package com.notify.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@JsonTypeInfo(use=Id.NAME,include=As.PROPERTY,property="notificationType")
@JsonSubTypes({
	@Type(value = EmailNotification.class, name = "EMAIL"),
	@Type(value = SlackNotification.class, name = "SLACK"),
})
public abstract class Notification {

	@NotBlank
	private String from;
	
	@NotEmpty
	private String [] to;
	
	@NotBlank
	private String subject;
	
	@NotNull
	private NotificationType notficationType;
	
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
	public NotificationType getNotficationType() {
		return notficationType;
	}
	public void setNotficationType(NotificationType notficationType) {
		this.notficationType = notficationType;
	}
	
}
