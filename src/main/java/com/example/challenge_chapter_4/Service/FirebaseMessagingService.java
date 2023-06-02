package com.example.challenge_chapter_4.Service;

import com.example.challenge_chapter_4.Notif.PushNotificationRequest;
import com.google.firebase.messaging.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
@Slf4j
public class FirebaseMessagingService {
    public void sendMessageToken(PushNotificationRequest pushNotificationRequest) throws InterruptedException, ExecutionException {
        Message message = getPreconfiguredMessageToToken(pushNotificationRequest);
        String response = sendAndGetResponse(message);
        log.info("Sent message to token. Device token: " + pushNotificationRequest.getToken() + ", Response: " + response);
    }

    private String sendAndGetResponse(Message message) throws InterruptedException, ExecutionException {
        return FirebaseMessaging.getInstance().sendAsync(message).get();
    }

    private WebpushConfig getWebpushConfig() {
        return WebpushConfig.builder()
                .setNotification(WebpushNotification.builder()
                        .setTitle("Title")
                        .setBody("Body")
                        .setIcon("icon-url")
                        .build())
                .build();
    }

    private Message getPreconfiguredMessageToToken(PushNotificationRequest request) {
        return Message.builder()
                .setWebpushConfig(getWebpushConfig())
                .setToken(request.getToken())
                .build();
    }
}