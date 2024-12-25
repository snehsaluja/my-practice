package com.practice.mypractice.programs.parkinglotsystem.dto;

public class Gate {

    String gateId;
    GateType gateType;

}

enum GateType {
    ENTRY,
    EXIT;
}