package com.practice.mypractice.interview10.googlecalendar.corecalendar.service;

import java.time.LocalDateTime;
import java.util.List;

import com.practice.mypractice.interview10.googlecalendar.corecalendar.entity.Event;
import com.practice.mypractice.interview10.googlecalendar.corecalendar.entity.User;

public interface CalendarService {

    Event createEvent(String eventTitle, String eventDesc, User organiser, LocalDateTime startTime, LocalDateTime endTime, List<User> guests);

    Event fetchEvent(String eventId);

    Event updateEvent(String eventId, String eventTitle, String eventDesc, User organiser, LocalDateTime startTime, LocalDateTime endTime, List<User> guests);

    Event deleteEvent(String eventId);

    void receiveEventInvite(Event event);

    boolean rsvpEvent(Event event, String status, String msg);

}
