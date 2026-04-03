package com.example.AOPTask.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private Long id;
   @Pattern(regexp = "^[a-zA-Z]{2,25}$",
        message ="Give positive number" )
    private String name;
    @Positive
    private double price;
    @Positive
    private int stock;

}
