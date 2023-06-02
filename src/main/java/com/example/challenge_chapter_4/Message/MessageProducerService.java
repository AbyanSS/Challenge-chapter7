package com.example.challenge_chapter_4.Message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageProducerService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(String message){
        rabbitTemplate.convertAndSend("myExchange", "myRoutingKey", message);
        System.out.println("Message sent to rabbit : " + message);
//        log.info(String.format("Message sent to rabbit" + message));
    }
}
