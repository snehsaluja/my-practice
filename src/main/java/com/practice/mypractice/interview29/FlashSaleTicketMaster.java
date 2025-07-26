package com.practice.mypractice.interview29;

// Agoda - Staff Software Engineer - Round 2 (System Design) - (11th Dec)

public class FlashSaleTicketMaster {
}

/*
Functional Requirements:

1. View events
2. View specific Event
3. Book an event - max 4 tickets per user
4. View booking details


NFP:
1. Concurrency
2. Availability



<Check image>

For booking at high concurrency:

Approach 1 : Pessimistic locking
Approach 2 : Have 3 statuses - Available, reserved, booked and Optimistic locking
Approach 3 : Distributed Locking with Redis. Redis to store Reserved state and booking DB to store Available and Booked state..
Approach 4 : Virtual Waiting Queue.

 */