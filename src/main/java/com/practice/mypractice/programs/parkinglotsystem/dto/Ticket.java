package com.practice.mypractice.programs.parkinglotsystem.dto;

import com.practice.mypractice.programs.parkinglotsystem.enums.TicketStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Ticket {

    String ticketId;
    Spot spot;
    LocalDateTime startTime;
    TicketStatus status;
}