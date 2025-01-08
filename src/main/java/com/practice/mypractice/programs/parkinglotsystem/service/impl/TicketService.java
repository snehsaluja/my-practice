package com.practice.mypractice.programs.parkinglotsystem.service.impl;

import com.practice.mypractice.programs.parkinglotsystem.dto.Spot;
import com.practice.mypractice.programs.parkinglotsystem.dto.Ticket;
import com.practice.mypractice.programs.parkinglotsystem.enums.VehicleType;

import java.time.LocalDateTime;

public class TicketService {

    public Ticket generateTicket(Spot spot,
                                 String vehicleNo,
                                 VehicleType type,
                                 LocalDateTime now) {
        return new Ticket();
    }

    boolean cancelTicket(Ticket ticket) {
        return true;
    }

}
