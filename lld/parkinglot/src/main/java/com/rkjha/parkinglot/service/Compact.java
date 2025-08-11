package com.rkjha.parkinglot.service;

public class Compact extends ParkingSpot {

    public Compact(Integer id) {
        super(id);
    }

    public boolean assignVehicle(Vehicle v) {
        if (isFree) {
            System.out.println("Allocated Compact slot " + id + " to " + v.getLicenseNo());
            this.vehicle = v;
            isFree = false;
            return true;
        }
        return false;
    }

}
