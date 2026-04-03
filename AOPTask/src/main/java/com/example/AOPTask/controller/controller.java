package com.example.AOPTask.controller;

import com.example.AOPTask.entity.Product;
import com.example.AOPTask.repository.OrderRepository;
import com.example.AOPTask.service.OrderService;
import com.example.AOPTask.service.ProductService;
import jakarta.persistence.criteria.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class controller {
    @Autowired
    private OrderService orderService;
    private ProductService productService;
   //1
    @PostMapping("/placeOrder")
    public Order placeOrder(
            @RequestParam Long userId,
            @RequestParam Long productId,
            @RequestParam Integer quantity
    ){
        return orderService.placeOrder(userId,productId,quantity);
    }
    //2
    @PutMapping("/update")
    public Product updateOrder(
            @RequestParam Long userId,
            @RequestParam Long productId,
            @RequestParam double price,
            @RequestParam int stock
    ){
        return  productService.updateProduct(userId,productId,price,stock);
    }
    @PutMapping("/cancel")
    public Order cancelOrder(
            @RequestParam Long userid,
            @RequestParam Long orderId){
        return orderService.cancelOrder(userid,orderId);
    }
}
