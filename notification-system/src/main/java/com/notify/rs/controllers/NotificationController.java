package com.notify.rs.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.notify.domain.NotificationMessage;
import com.notify.service.NotificationService;

@RestController
@RequestMapping("/notification")
public class NotificationController {

	private static final Logger logger = LoggerFactory.getLogger(NotificationController.class);
	
	@Autowired
	private NotificationService notificationService;
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void push(@Valid @RequestBody NotificationMessage notification) {
		logger.info("Received notification {}", notification);
		notificationService.send(notification);
	}
}
