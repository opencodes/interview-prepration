package com.rkjha.parkinglot.service;

public class MotorcycleSpot extends ParkingSpot {
    public MotorcycleSpot(Integer id) {
        super(id);
    }

    public boolean assignVehicle(Vehicle v) {
        if (isFree) {
            System.out.println("Allocated Motorcycle slot " + id + " to " + v.getLicenseNo());
            this.vehicle = v;
            isFree = false;
            return true;
        }
        return false;
    }
}