package com.example.AOPTask.service;

import com.example.AOPTask.entity.Product;
import com.example.AOPTask.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public  Product updateProduct(Long userId,Long productId,double price,int stock){
        Product product=productRepository.findById(productId).orElseThrow(()->new RuntimeException("Product Not found"));
        //update
        product.setPrice(price);
        product.setStock(stock);
          return productRepository.save(product);

    }
}
