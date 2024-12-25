package com.practice.mypractice.programs.parkinglotsystem.service;

import com.practice.mypractice.programs.parkinglotsystem.dto.Ticket;
import com.practice.mypractice.programs.parkinglotsystem.enums.VehicleType;

public interface ParkingMgtService {

    Ticket entry(String vehicleNo, VehicleType type, String gateId);

    double exit(String ticketId);
}
