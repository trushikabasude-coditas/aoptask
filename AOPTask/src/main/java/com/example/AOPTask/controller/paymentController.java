package com.example.AOPTask.controller;

import com.example.AOPTask.entity.Product;
import com.example.AOPTask.repository.ProductRepository;
import com.example.AOPTask.service.paymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pay")
public class paymentController {
    @Autowired
    private paymentService paymentservice;
    @PostMapping("/DoPayment")
    public String DoPayment(Long userId, double amt){
        return paymentservice.processPayment(userId,amt);
    }
}
