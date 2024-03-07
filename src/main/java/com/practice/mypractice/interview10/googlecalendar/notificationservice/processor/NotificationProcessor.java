package com.practice.mypractice.interview10.googlecalendar.notificationservice.processor;

import com.practice.mypractice.interview10.googlecalendar.corecalendar.entity.Event;
import com.practice.mypractice.interview10.googlecalendar.notificationservice.strategies.NotificationStrategy;

public class NotificationProcessor {

    NotificationStrategy notificationStrategy;

    NotificationProcessor(NotificationStrategy notificationStrategy) {
        this.notificationStrategy = notificationStrategy;
    }

    public void notify(Event event){
        notificationStrategy.notify(event);
    }

}
