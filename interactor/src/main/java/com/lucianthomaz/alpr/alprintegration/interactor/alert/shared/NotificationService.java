package com.lucianthomaz.alpr.alprintegration.interactor.alert.shared;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public static void sendPushNotification(String deviceFCMToken, String title, String body) {
        Message message = Message.builder()
                .setNotification(Notification.builder().setTitle(title).setBody(body).build())
                .setToken(deviceFCMToken)
                .build();

        try {
            FirebaseMessaging.getInstance().send(message);
            // Handle success or log the success
        } catch (Exception e) {
            // Handle error or log the error
        }
    }
    public static void sendPushNotificationWithData(String deviceFCMToken, String title, String body, String data) {
        Message message = Message.builder()
                .setNotification(Notification.builder().setTitle(title).setBody(body).build())
                .putData("locationDetails", data)
                .setToken(deviceFCMToken)
                .build();

        try {
            FirebaseMessaging.getInstance().send(message);
            // Handle success or log the success
        } catch (Exception e) {
            // Handle error or log the error
        }
    }
}