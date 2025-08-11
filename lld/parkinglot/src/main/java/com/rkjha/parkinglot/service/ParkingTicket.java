package com.rkjha.parkinglot.service;

import java.time.LocalDateTime;

import com.rkjha.parkinglot.model.enums.TicketStatus;

public class ParkingTicket {
    String id;
    // datetime for entry and exit
    LocalDateTime entryDate;
    LocalDateTime exiDate;
    double amount;
    TicketStatus status;
    Vehicle vehicle;
    Payment payment;
    Entrance entrance;
    Exit exit;

    public ParkingTicket(String id, LocalDateTime entryDate, Vehicle vehicle, Entrance entrance) {
        this.id = id;
        this.entryDate = entryDate;
        this.vehicle = vehicle;
        this.status = TicketStatus.INUSE; // Default status when created
        this.entrance = entrance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDateTime entryDate) {
        this.entryDate = entryDate;
    }

    public LocalDateTime getExiDate() {
        return exiDate;
    }

    public void setExiDate(LocalDateTime exiDate) {
        this.exiDate = exiDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Entrance getEntrance() {
        return entrance;
    }

    public void setEntrance(Entrance entrance) {
        this.entrance = entrance;
    }

    public Exit getExit() {
        return exit;
    }

    public void setExit(Exit exit) {
        this.exit = exit;
    }

}
