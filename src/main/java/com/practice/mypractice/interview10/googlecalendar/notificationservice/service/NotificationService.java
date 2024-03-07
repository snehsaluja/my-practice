package com.practice.mypractice.interview10.googlecalendar.notificationservice.service;

public class NotificationService {

    void processPubSubMessage(/* Message msg */) {
        /*
         * Pseudo Code:

        if(msg.type = "REMINDER") {
            event = mapping(msg);
            NotificationProcessor notificationProcessor = new NotificationProcessor(new PushNotificationStrategy());
        } else if (msg.type = "EVENT_CREATE") {
            event = mapping(msg);
            NotificationProcessor notificationProcessor = new NotificationProcessor(new EmailNotificationStrategy());
        }
        notificationProcessor.notify(event);
        */
    }

}
