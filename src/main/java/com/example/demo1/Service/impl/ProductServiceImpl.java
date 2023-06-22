package com.example.demo1.Service.impl;

import com.example.demo1.Exception.ResourceNotFoundException;
import com.example.demo1.Service.ProductService;
import com.example.demo1.entites.Product;
import com.example.demo1.payload.ProductDto;
import com.example.demo1.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService {

    private  final ProductRepo productRepo;

    @Autowired
    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product save = productRepo.save(mapToEntity(productDto));
        return  mapToDto(save);

    }

    @Override
    public List<ProductDto> getAllProduct() {
       List<Product> products= productRepo.findAll();
       return products.stream().map(ProductServiceImpl::mapToDto).collect(Collectors.toList());


    }

    @Override
    public ProductDto updateProduct(int id, ProductDto productDto) {
        Product product=productRepo.findById(id).orElseThrow(()->new ResourceNotFoundException());
        Product product1 = mapToEntity(productDto);
        product1.setId(product.getId());

      return mapToDto( productRepo.save(product1));

    }

    @Override
    public boolean deleteProduct(int id) {
       if( productRepo.existsById(id)){
           productRepo.deleteById(id);
           return true;
       }
       return  false;
    }

    private static Product  mapToEntity(ProductDto productDto){
        Product product = new Product();
        product.setName(product.getName());
        product.setPrize(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        product.setQuantity(productDto.getQuantity());
        return product;
    }

    private static ProductDto mapToDto(Product product){
         ProductDto productDto = new ProductDto();
         productDto.setName(product.getName());
         productDto.setDescription(productDto.getDescription());
         productDto.setPrice(product.getPrize());
         productDto.setQuantity(product.getQuantity());
         return productDto;
    }
}










