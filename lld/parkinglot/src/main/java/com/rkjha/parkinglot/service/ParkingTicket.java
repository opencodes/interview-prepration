package com.rkjha.parkinglot.service;

import java.sql.Date;

import com.rkjha.parkinglot.model.enums.TicketStatus;

public class ParkingTicket {
    int ticketId;
    Date entryDate;
    Date exiDate;
    double amount;
    TicketStatus status;
    Vehicle vehicle;
    Payment payment;
    Entrance entrance;
    Exit exit;

    public ParkingTicket(int ticketId, Date entryDate, Vehicle vehicle) {
        this.ticketId = ticketId;
        this.entryDate = entryDate;
        this.vehicle = vehicle;
        this.status = TicketStatus.INUSE; // Default status when created
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Date getExiDate() {
        return exiDate;
    }

    public void setExiDate(Date exiDate) {
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
