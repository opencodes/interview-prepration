package com.rkjha.parkinglot.service;

import java.sql.Date;

public class Entrance {
    String id;

    public Entrance(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }


    public ParkingTicket getTicket(Vehicle vehicle) {
        ParkingTicket ticket = new ParkingTicket(id, new Date(0), vehicle, this);
        // ticket.setVehicle(vehicle);
        // vehicle.assignTicket(ticket);
        return ticket;
    }
}
