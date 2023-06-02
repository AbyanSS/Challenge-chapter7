package com.example.challenge_chapter_4.Message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageConsumerService {
    @RabbitListener(queues = "myQueue")
    public void recieveMessage(String message){
        System.out.println("Message received : " + message);
//        log.info(String.format("Message received : " + message));
    }
}
