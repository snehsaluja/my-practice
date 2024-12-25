package com.practice.mypractice.programs.parkinglotsystem.strategy;

import com.practice.mypractice.programs.parkinglotsystem.enums.PaymentMethod;

public interface PaymentStrategy {

    boolean pay(double amount, PaymentMethod method);
}
