package com.practice.mypractice.programs.parkinglotsystem.dto;

import java.util.Map;

public class ExitGate extends Gate {

    ExitGate() {
        super(GateType.EXIT);
    }

    Map<String, BillingDesk> billingDesks;
}
