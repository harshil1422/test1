package com.example.demo1.Service;

import com.example.demo1.payload.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto);

    List<ProductDto> getAllProduct();

    ProductDto updateProduct(int id, ProductDto productDto);

    boolean deleteProduct(int id);
}
