package com.notify.receiver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.kafka.annotation.EnableKafka;

@EnableAutoConfiguration()
@EnableKafka
@SpringBootApplication
public class NotificationReceiverApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationReceiverApplication.class, args);
	}
}
