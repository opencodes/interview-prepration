package com.rkjha.parkinglot.service;

public class ParkingRate {
    private double hour;
    private double rate;

    public double calculateRate() {
        return this.hour * this.rate;
    }
     
}
