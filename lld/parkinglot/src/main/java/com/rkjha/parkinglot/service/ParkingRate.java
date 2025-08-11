package com.rkjha.parkinglot.service;

import java.time.Duration;

public class ParkingRate {
    private double hourlyRate;
    private double fixedRate;
    private double fixedRateForHour = 4.0;

    public ParkingRate(double hourlyRate, double fixedRate, double fixedRateForHour) {
        this.hourlyRate = hourlyRate;
        this.fixedRate = fixedRate;
        this.fixedRateForHour = fixedRateForHour;
    }

    public double calculate(ParkingTicket parkingTicket) {
        // Method 1: Duration (good for hours/minutes/seconds)
        Duration duration = Duration.between(parkingTicket.entryDate, parkingTicket.exiDate);
        long hrs = duration.toHours();
        double fee = this.fixedRate;
        if (hrs >= this.fixedRateForHour)
            fee += (hrs - this.fixedRateForHour) * this.hourlyRate;
        return fee;
    }

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
