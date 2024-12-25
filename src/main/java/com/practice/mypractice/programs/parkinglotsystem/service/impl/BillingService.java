package com.practice.mypractice.programs.parkinglotsystem.service.impl;

import com.practice.mypractice.programs.parkinglotsystem.dto.ParkingLot;
import com.practice.mypractice.programs.parkinglotsystem.dto.Ticket;

public class BillingService {

    double calculateBillAmount(ParkingLot lot, Ticket ticket) {
        lot.getVehicleBaseRateMap().get(ticket.getSpot().getVehicleType());
        lot.getVehicleAdditionalHourRateMap().get(ticket.getSpot().getVehicleType());
        return 0.0;
        // return (base rate for 1st hour) + (extra hours * additionalRate)
    }

}
