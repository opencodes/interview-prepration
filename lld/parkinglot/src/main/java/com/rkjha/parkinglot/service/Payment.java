package com.rkjha.parkinglot.service;

import java.sql.Date;

import com.rkjha.parkinglot.model.enums.PaymentStatus;

abstract class Payment {
    double amount;
    PaymentStatus status;
    Date timestamp;

    public boolean initiateTransaction() {
        // Logic to initiate payment transaction
        return false;
    }
}
