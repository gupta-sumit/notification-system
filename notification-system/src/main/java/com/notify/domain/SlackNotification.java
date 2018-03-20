package com.notify.domain;

import java.util.Arrays;

public class SlackNotification extends Notification {

	@Override
	public String toString() {
		return "SlackNotification [getFrom()=" + getFrom() + ", getTo()=" + Arrays.toString(getTo()) + ", getSubject()="
				+ getSubject() + ", getNotficationType()=" + getNotficationType() + "]";
	}

	
}
