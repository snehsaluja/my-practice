package com.practice.mypractice.programs.parkinglotsystem.dto;

import com.practice.mypractice.programs.parkinglotsystem.enums.VehicleType;
import lombok.Data;

@Data
public class Spot {

    String spotId;
    boolean isOccupied;
    VehicleType vehicleType;

}
