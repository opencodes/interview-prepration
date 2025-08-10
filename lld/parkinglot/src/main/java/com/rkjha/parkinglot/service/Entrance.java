package com.rkjha.parkinglot.service;

public class Entrance {
    int id;
    public ParkingTicket getTicket(Vehicle vehicle) {
        ParkingTicket ticket = new ParkingTicket(id, null, vehicle);
        ticket.setVehicle(vehicle);
        vehicle.assignTicket(ticket);
        return ticket;
    }
}
