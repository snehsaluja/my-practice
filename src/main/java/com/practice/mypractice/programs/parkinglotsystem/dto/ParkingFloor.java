package com.practice.mypractice.programs.parkinglotsystem.dto;

import com.practice.mypractice.programs.parkinglotsystem.enums.VehicleType;

import java.util.List;
import java.util.Map;
import java.util.Queue;

public class ParkingFloor {

    String floorId;
    Map<String, Spot> spots;
    Map<VehicleType, List<Spot>> availableSpots;
    Map<VehicleType, List<Spot>> occupiedSpots;

    // List<Spot> spots;
    // Queue<Spot> availableSpots;
    // Queue<Spot> occupiedSpots;

    // Map<VehicleType, Integer> floorCapacity;
    /*
    int availableSmallSpots;
    int availableMediumSpots;
    int availableBigSpots;*/

}
