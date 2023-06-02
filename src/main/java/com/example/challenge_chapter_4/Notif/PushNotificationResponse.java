package com.example.challenge_chapter_4.Notif;

import lombok.Data;

@Data
public class PushNotificationResponse {
    private int status;
    private String message;

    public PushNotificationResponse(){

    }

    public PushNotificationResponse(int status, String message){
        this.status = status;
        this.message = message;
    }
}