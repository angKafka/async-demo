package org.rdutta.kafkatest.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {

    @KafkaListener(topics = {"message-queue"}, groupId = "console-consumer-49264")
    public void consumeMessage(String message){
        System.out.println(message);
    }
}
