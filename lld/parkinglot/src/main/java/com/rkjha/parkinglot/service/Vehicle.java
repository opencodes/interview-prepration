package com.rkjha.parkinglot.service;

abstract class Vehicle {
    private String vehicleNumber;
    private ParkingTicket ticket;

    public String getVehicleNumber() {
        return vehicleNumber;
    } 
    public ParkingTicket getTicket() {
        return ticket;
    }
    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
    public void assignTicket(ParkingTicket ticket) {
        this.ticket = ticket;
    }
}
