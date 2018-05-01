package com.notify.store;

import java.util.stream.Stream;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.notify.model.Message;

public interface MessageStore extends MongoRepository<Message, String> {

	@Query("{ 'sourceApplicationId' : ?0 }")
	public Stream<Message> findMessagesBySourceApplicationId(String sourceApplicationId);
	
}
