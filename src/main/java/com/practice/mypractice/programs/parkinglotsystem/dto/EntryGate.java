package com.practice.mypractice.programs.parkinglotsystem.dto;

import java.util.Map;

public class EntryGate extends Gate {

    EntryGate() {
        super(GateType.ENTRY);
    }

    Map<String, TicketKiosk> ticketKiosks;
}
