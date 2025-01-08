package com.practice.mypractice.programs.parkinglotsystem.dto;

import com.practice.mypractice.programs.parkinglotsystem.enums.VehicleType;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class ParkingLot {

    private String id;
    private Map<String, ParkingFloor> floors;
    private Map<String, Gate> entryGates;
    private Map<String, Gate> exitGates;
    private Map<String, Ticket> ticketsMap;
    private Map<VehicleType, Double> vehicleBaseRateMap;
    private Map<VehicleType, Double> vehicleAdditionalHourRateMap;
    private Map<String, Map<VehicleType, Integer>> floorAvailableCapacity; // floor -> VehicleType -> capacity

    public Ticket getTicket(String ticketId) {
        return getTicketsMap().get(ticketId);
    }


    /*double smallVehicleRate;
    double mediumVehicleRate;
    double bigVehicleRate;
*/
}
