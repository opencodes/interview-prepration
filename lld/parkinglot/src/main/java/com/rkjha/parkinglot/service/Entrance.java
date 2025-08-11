package com.rkjha.parkinglot.service;

import java.time.LocalDateTime;

public class Entrance {
    String id;

    public Entrance(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public ParkingTicket getTicket(Vehicle vehicle, String ticketId) {
        ParkingTicket ticket = new ParkingTicket(ticketId, LocalDateTime.now(), vehicle, this);
        // ticket.setVehicle(vehicle);
        // vehicle.assignTicket(ticket);
        return ticket;
    }
}
