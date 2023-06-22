package com.example.demo1.payload;

import lombok.Data;

@Data
public class ProductDto {
    private long id;
    private String name;
    private double price;
    private  String description;
    private int quantity;
}
