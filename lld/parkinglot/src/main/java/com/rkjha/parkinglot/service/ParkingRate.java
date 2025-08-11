package com.rkjha.parkinglot.service;

public class ParkingRate {
    private double hourlyRate = 100;
    private double fixedRate = 50;
    private double fixedRateForHour = 4.0;

    // public ParkingRate(double hourlyRate, double fixedRate, double
    // fixedRateForHour) {
    // this.hourlyRate = hourlyRate;
    // this.fixedRate = fixedRate;
    // this.fixedRateForHour = fixedRateForHour;
    // }

    public double calculate(double hours, Vehicle v, ParkingSpot s) {
        int hrs = (int) Math.ceil(hours);
        double fee = 0;
        if (hrs >= 1)
            fee += 4;
        if (hrs >= 2)
            fee += 3.5;
        if (hrs >= 3)
            fee += 3.5;
        if (hrs > 3)
            fee += (hrs - 3) * 2.5;
        return fee;
    }

    // public double calculate(ParkingTicket parkingTicket) {
    // // Method 1: Duration (good for hours/minutes/seconds)
    // Duration duration = Duration.between(parkingTicket.entryDate,
    // parkingTicket.exiDate);
    // long hrs = duration.toHours();
    // double fee = this.fixedRate;
    // if (hrs >= this.fixedRateForHour)
    // fee += (hrs - this.fixedRateForHour) * this.hourlyRate;
    // return fee;
    // }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double getFixedRate() {
        return fixedRate;
    }

    public void setFixedRate(double fixedRate) {
        this.fixedRate = fixedRate;
    }

    public double getFixedRateForHour() {
        return fixedRateForHour;
    }

    public void setFixedRateForHour(double fixedRateForHour) {
        this.fixedRateForHour = fixedRateForHour;
    }

}
