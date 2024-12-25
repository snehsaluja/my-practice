package com.practice.mypractice.programs.parkinglotsystem.strategy;

import com.practice.mypractice.programs.parkinglotsystem.dto.Gate;
import com.practice.mypractice.programs.parkinglotsystem.dto.ParkingLot;
import com.practice.mypractice.programs.parkinglotsystem.dto.Spot;
import com.practice.mypractice.programs.parkinglotsystem.enums.VehicleType;

public class NearestSpotStrategy implements SpotAllocationStrategy {

    public Spot allocateSpot(ParkingLot lot, Gate entryGate, VehicleType vehicleType) {
        return new Spot();
    }

    public void deallocateSpot(ParkingLot lot, Spot spot) {

    }

}
