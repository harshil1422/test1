package com.example.demo1.repository;

import com.example.demo1.entites.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Integer> {
}
