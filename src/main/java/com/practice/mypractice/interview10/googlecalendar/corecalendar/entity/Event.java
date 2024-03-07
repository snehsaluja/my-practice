package com.practice.mypractice.interview10.googlecalendar.corecalendar.entity;

import java.time.LocalDateTime;
import java.util.List;

public class Event {

    String eventId;
    String eventTitle;
    String eventDesc;
    User organiser;
    LocalDateTime startTime;
    LocalDateTime endTime;
    List<User> guests;

}
