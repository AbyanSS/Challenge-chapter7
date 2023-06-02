package com.example.challenge_chapter_4.Service;

import com.example.challenge_chapter_4.Notif.PushNotificationRequest;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PushNotificationService {
    @Autowired
    FirebaseMessagingService firebaseMessagingService;

    public void sendPushNotificationToken(PushNotificationRequest pushNotificationRequest){
        try{
            firebaseMessagingService.sendMessageToken(pushNotificationRequest);
        }catch(Exception e){
            log.error(e.getMessage());
        }
    }
}
