package com.rkjha.parkinglot.service;

public class Entrance {
    String id;

    public Entrance(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public ParkingTicket getTicket(Vehicle v) {
        return ParkingLot.getInstance().parkVehicle(v);
    }
}
