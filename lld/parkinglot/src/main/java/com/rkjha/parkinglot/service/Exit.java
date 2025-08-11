package com.rkjha.parkinglot.service;

import java.time.LocalDateTime;

public class Exit {
    String id;

    public Exit(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public ParkingTicket markExit(ParkingTicket ticket, ParkingRate parkingRate) {
        // Set exit time
        ticket.exiDate = LocalDateTime.now();
        // Calculate amount
        ticket.amount = parkingRate.calculate(ticket);
        return ticket;
    }
}
