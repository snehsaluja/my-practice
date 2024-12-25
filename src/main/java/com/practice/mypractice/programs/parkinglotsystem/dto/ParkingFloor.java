package com.practice.mypractice.programs.parkinglotsystem.dto;

import com.practice.mypractice.programs.parkinglotsystem.enums.VehicleType;

import java.util.List;
import java.util.Map;
import java.util.Queue;

public class ParkingFloor {

    String floorId;
    List<Spot> spots;

    Queue<Spot> availableSpots;
    Queue<Spot> occupiedSpots;

    /*
    int availableSmallSpots;
    int availableMediumSpots;
    int availableBigSpots;*/
    Map<VehicleType, Integer> floorCapacity;

}
