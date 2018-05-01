package com.notify.rs.web;

import static com.notify.rs.web.ResponseEntityMappers.accepted;
import static com.notify.rs.web.ResponseEntityMappers.notFound;
import static com.notify.rs.web.ResponseEntityMappers.ok;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notify.facade.NotificationFacade;
import com.notify.model.Message;
import com.notify.service.NotificationQueryService;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/notifications")
@AllArgsConstructor
@Slf4j
public class NotificationController {

	private final @NonNull NotificationFacade notificationFacade;
	
	private final @NonNull NotificationQueryService notificationQueryService;
		
	@GetMapping(path="/{sourceAppId}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Message>> getAllMessagesBySourceAppId(@PathVariable("sourceAppId") String sourceAppId) {
		Stream<Message> messagesStream = notificationQueryService.getMessagesBySourceApplicationId(sourceAppId);
		List<Message> messages = Optional.ofNullable(messagesStream).orElse(Stream.of()).collect(Collectors.toList());
		return ok(messages);
	}
	
	@GetMapping(path="/{sourceAppId}/message/{messageId}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Message> getAllMessagesBySourceAppId(@PathVariable("sourceAppId") String sourceAppId, @PathVariable("messageId") String id) {
		Optional<Message> message = notificationQueryService.getById(id);
		return message.map(ResponseEntityMappers::ok).orElse(notFound());
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CreateNotificationResponse> createNotificationMessage(@Valid @RequestBody CreateNotificationRequest createNotificationRequest) {
		log.info("Received notification {}", createNotificationRequest);
		Message message = Mappers.toMessage("Test").apply(createNotificationRequest);
		Message persistedMessage = notificationFacade.createAndSendMessage(message);
		return accepted(Mappers.toCreateNotificationResponse().apply(persistedMessage));
	}
}
