package com.practice.mypractice.interview10.googlecalendar.notificationservice.strategies;

import com.practice.mypractice.interview10.googlecalendar.corecalendar.entity.Event;

public interface NotificationStrategy {
    void notify(Event event);
}
