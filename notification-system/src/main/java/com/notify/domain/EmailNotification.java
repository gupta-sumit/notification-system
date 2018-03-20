package com.notify.domain;

import java.util.Arrays;

public class EmailNotification extends Notification {

	private String [] cc;
	private String [] bcc;
	private String body;
	public String[] getCc() {
		return cc;
	}
	public void setCc(String[] cc) {
		this.cc = cc;
	}
	public String[] getBcc() {
		return bcc;
	}
	public void setBcc(String[] bcc) {
		this.bcc = bcc;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	@Override
	public String toString() {
		return "EmailNotification [cc=" + Arrays.toString(cc) + ", bcc=" + Arrays.toString(bcc) + ", body=" + body
				+ ", getFrom()=" + getFrom() + ", getTo()=" + Arrays.toString(getTo()) + ", getSubject()="
				+ getSubject() + ", getNotficationType()=" + getNotficationType() + "]";
	}
	
}
