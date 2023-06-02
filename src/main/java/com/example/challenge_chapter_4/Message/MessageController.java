package com.example.challenge_chapter_4.Message;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(value = "/Msg")
@Api(value = "Message")
public class MessageController {
    @Autowired
    private MessageProducerService messageProducerService;

    @GetMapping("/testAPI")
    public String testAPI(){
        return "Test Hello World";
    }

    @GetMapping("/testMessage")
    public String testSend(){
        String message = "Test ini message dari rabbit";
        messageProducerService.sendMessage(message);
        return message;
    }
}
