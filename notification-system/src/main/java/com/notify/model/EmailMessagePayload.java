package com.notify.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class EmailMessagePayload extends MessagePayload {

	private @NonNull EmailAddress from;
	private @NonNull EmailAddress [] to;
	private EmailAddress [] cc;
	private EmailAddress [] bcc;
	private @NonNull String subject;
	private String body;
}
