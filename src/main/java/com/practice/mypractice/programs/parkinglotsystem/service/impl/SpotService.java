package com.practice.mypractice.programs.parkinglotsystem.service.impl;

import com.practice.mypractice.programs.parkinglotsystem.dto.Gate;
import com.practice.mypractice.programs.parkinglotsystem.dto.ParkingLot;
import com.practice.mypractice.programs.parkinglotsystem.dto.Spot;
import com.practice.mypractice.programs.parkinglotsystem.enums.VehicleType;
import com.practice.mypractice.programs.parkinglotsystem.strategy.SpotAllocationStrategy;

public class SpotService {

    SpotAllocationStrategy strategy;

    public Spot findSpot(ParkingLot lot, Gate entryGate, VehicleType vehicleType) {
        return strategy.allocateSpot(lot, entryGate, vehicleType);
    }

    public void deallocateSpot(ParkingLot lot, Spot spot) {
        strategy.deallocateSpot(lot, spot);
    }
}
