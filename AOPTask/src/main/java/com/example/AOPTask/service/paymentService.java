package com.example.AOPTask.service;

import org.springframework.stereotype.Service;

@Service
public class paymentService {
    public String processPayment(Long userId, double amount) {
        if (amount <= 0) {//valid
            throw new RuntimeException("Amount invalid");
        }
        if (amount > 1000) {
            throw new RuntimeException("Payment Gteway failure");
        }
        return "Success 1234T"+System.currentTimeMillis();
    }
}
