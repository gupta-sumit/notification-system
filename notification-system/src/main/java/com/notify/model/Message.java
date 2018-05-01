package com.notify.model;

import static com.notify.common.utils.Validations.notBlank;
import static com.notify.common.utils.Validations.notNull;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Setter
@Getter
public class Message {

	@Id
	private String id;
	private @NonNull String sourceApplicationId;
	private @NonNull MessagePayload payload;
	private MessageStatus status;
	private @NonNull LocalDate createdDate;
	private @NonNull String createdBy;
	private LocalDate modifiedDate;
	private String modifiedBy;
	
	public static Message create(String sourceAppId, MessagePayload messagePayload, String userId) {
		Message message = new Message();
		message.sourceApplicationId = notBlank(sourceAppId,"sourceAppId");
		message.payload = notNull(messagePayload, "messagePayload");
		message.createdBy = notBlank(sourceAppId,"userId");
		message.status = MessageStatus.PENDING;
		message.createdDate = LocalDate.now();
		return message;
	}
	
}
