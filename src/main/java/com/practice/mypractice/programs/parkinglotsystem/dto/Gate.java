package com.practice.mypractice.programs.parkinglotsystem.dto;

public class Gate {

    String gateId;
    GateType gateType;

    public Gate(GateType gateType) {
        this.gateType = gateType;
    }
}

enum GateType {
    ENTRY,
    EXIT;
}