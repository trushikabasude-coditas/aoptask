package com.example.AOPTask.service;

import com.example.AOPTask.entity.Product;
import com.example.AOPTask.repository.OrderRepository;
import com.example.AOPTask.repository.ProductRepository;
import jakarta.persistence.criteria.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class OrderService {
    @Autowired
    private ProductRepository prodRepository;
    @Autowired
    private OrderRepository orderRepository;
    public Order placeOrder(Long userId,Long productId,int quantity){
        Product product=prodRepository.findById(productId)
                .orElseThrow(()->new RuntimeException("Product Not found"));
    //seeing the stocks availability
    if(product.getStock() < quantity) {
        throw new RuntimeException("Stocks are not there !!!");
    }
    //reduce stock
    product.setStock(product.getStock()-quantity);
     prodRepository.save(product);
     Order order=new Order();
     order.setUserId(userId);
     order.setProductid(productId);
     order.setQuantity(quantity);
     order.setStatus("CREATED");
     return orderRepository.save(order);
  }

  //cancel order
    public Order cancelOrder(Long userId,Long orderId){
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        if (!order.getUserId().equals(userId)) {
            throw new RuntimeException("You cannot cancel this order");
        }

        order.setStatus("CANCELLED");

        return orderRepository.save(order);
    }
}
