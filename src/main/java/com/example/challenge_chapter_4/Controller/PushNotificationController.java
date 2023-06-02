package com.example.challenge_chapter_4.Controller;

import com.example.challenge_chapter_4.Notif.PushNotificationRequest;
import com.example.challenge_chapter_4.Notif.PushNotificationResponse;
import com.example.challenge_chapter_4.Service.PushNotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/Notifications")
@Slf4j
public class PushNotificationController {
    @Autowired
    PushNotificationService pushNotificationService;

    @PostMapping("/token")
    public ResponseEntity sendTokenNotification(@RequestBody PushNotificationRequest request) {
        pushNotificationService.sendPushNotificationToken(request);
        log.info("Sent push notification");
        return new ResponseEntity<>(new PushNotificationResponse(HttpStatus.OK.value(), "Notification has been sent."), HttpStatus.OK);
    }
}