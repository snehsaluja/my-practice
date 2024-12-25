package com.practice.mypractice.programs.parkinglotsystem.service.impl;

import com.practice.mypractice.programs.parkinglotsystem.dto.ParkingLot;
import com.practice.mypractice.programs.parkinglotsystem.dto.Spot;
import com.practice.mypractice.programs.parkinglotsystem.dto.Ticket;
import com.practice.mypractice.programs.parkinglotsystem.enums.VehicleType;
import com.practice.mypractice.programs.parkinglotsystem.service.ParkingMgtService;

import java.time.LocalDateTime;
import java.util.Map;

public class ParkingMgtServiceImpl implements ParkingMgtService {

    SpotService spotService;
    ParkingLot parkingLot;
    TicketService ticketService;
    BillingService billingService;


    // Should be called from Controller Layer:::::
    @Override
    public Ticket entry(String vehicleNo, VehicleType type, String gateId) {
        Spot spot = spotService.findSpot(parkingLot, parkingLot.getEntryGates().get(gateId), type);
        // Time Now()
        // Generate Ticket
        return ticketService.generateTicket(spot, vehicleNo, type, LocalDateTime.now());
    }

    // Should be called from Controller Layer:::::
    @Override
    public double exit(String ticketId) {
        Ticket ticket = parkingLot.getTicket(ticketId);
        double amount = billingService.calculateBillAmount(parkingLot, ticket);
        spotService.deallocateSpot(parkingLot, ticket.getSpot());
        return amount;
    }

    // Should be called from Controller Layer:::::
    public Map<String, Map<VehicleType, Integer>> getAvailableCapacity() {
        return parkingLot.getAvailableCapacity();
    }

}
