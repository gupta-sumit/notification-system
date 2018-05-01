package com.notify.rs.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseEntityMappers {

	public static <T> ResponseEntity<T> ok(T body) {
		return new ResponseEntity<T>(body, HttpStatus.OK);
	}
	
	public static <T> ResponseEntity<T> notFound() {
		return new ResponseEntity<T>(HttpStatus.NOT_FOUND);
	}
	
	public static <T> ResponseEntity<T> accepted(T body) {
		return new ResponseEntity<T>(HttpStatus.ACCEPTED);
	}
}
