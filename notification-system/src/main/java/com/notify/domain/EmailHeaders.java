package com.notify.domain;

public class EmailHeaders extends Headers{

	private String [] cc;
	private String [] bcc;
	
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

	
}

