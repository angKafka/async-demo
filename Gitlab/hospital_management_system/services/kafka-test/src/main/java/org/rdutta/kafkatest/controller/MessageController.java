package org.rdutta.kafkatest.controller;

import org.rdutta.kafkatest.consumer.MessageConsumer;
import org.rdutta.kafkatest.model.Message;
import org.rdutta.kafkatest.producer.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/messages")
public class MessageController {

    private final MessageProducer messageProducer;

    @Autowired
    public MessageController(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    @PostMapping("/send")
    public void sendMessage(@RequestBody Message message) {
        String topic = "message-queue";
        message.setTopic(topic);
        messageProducer.sendMessage(message);
    }
}
