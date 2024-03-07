package com.practice.mypractice.interview10.googlecalendar.corecalendar.entity;
/*

****** Walmart Round 2:


* Functional requirements =
*   1. Create an event - event id , event title, desc, user_id, List<Users> guests
*   2. Get a List of events between a start date and end date
*   3. Get an event based on event-id
*
*
* Non-func:
*   1. Available
*   2. scalable
*   3. modular
*
*
* Actors:
*   1. User
*   2. System
*
* Entities:
*   1. Event
*   2. User
*   3. Calendar
*
* Service:
*   Notification (service)
*
 * no. sec = 86400 = 1,00,000*
* 10,00,000 users
* 5 events per day
* total events created = 50,00,000/per day
* 50 per sec

*
* read per user = 20 per day
* total reads = 2,00,00,000
* 200 per sec
*
*
* min pods = 2
* max pods = 20
*
* */

import java.util.List;

public class Calendar {

    List<Event> events;
    User user;

}
