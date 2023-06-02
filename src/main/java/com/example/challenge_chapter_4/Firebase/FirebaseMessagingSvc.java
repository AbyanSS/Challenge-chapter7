//package com.example.challenge_chapter_4.Firebase;
//
//import com.google.firebase.messaging.FirebaseMessaging;
//import com.google.firebase.messaging.FirebaseMessagingException;
//import com.google.firebase.messaging.Message;
//import org.springframework.stereotype.Service;
//
//@Service
//public class FirebaseMessagingSvc {
//
//    public String sendMessage() throws FirebaseMessagingException {
//        Message msg = Message.builder()
//                .putData("body","Hello Binarian!")
//                .setTopic("project.firebase")
//                .build();
//        return FirebaseMessaging.getInstance().send(msg);
//    }
//}
