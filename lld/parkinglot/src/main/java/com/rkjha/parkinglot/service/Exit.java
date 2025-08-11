package com.rkjha.parkinglot.service;

public class Exit {
    String id;

    public Exit(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }
    public boolean validateTicket(ParkingTicket ticket) {
        return false;
    }
}
