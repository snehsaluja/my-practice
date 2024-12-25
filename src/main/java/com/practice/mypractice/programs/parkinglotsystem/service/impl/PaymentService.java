package com.practice.mypractice.programs.parkinglotsystem.service.impl;

import com.practice.mypractice.programs.parkinglotsystem.enums.PaymentMethod;
import com.practice.mypractice.programs.parkinglotsystem.strategy.PaymentStrategy;

public class PaymentService {

    PaymentStrategy paymentStrategy;


    // Should be called from Controller Layer:::::
    boolean makePayment(double amount, PaymentMethod method) {
        return paymentStrategy.pay(amount, method);
    }
}
