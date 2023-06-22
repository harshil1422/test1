package com.example.demo1.Controller;

import com.example.demo1.Service.ProductService;
import com.example.demo1.payload.ProductDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/post")
    private ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){

          ProductDto productDto1=productService.createProduct(productDto);
          return new ResponseEntity<ProductDto>(productDto1, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    private ResponseEntity<List<ProductDto>> getAllProduct(){
        List<ProductDto> productDtoS =productService.getAllProduct();
        return new ResponseEntity<>(productDtoS,HttpStatus.FOUND);
    }
    @PutMapping("/put/{id}")
    private ResponseEntity<ProductDto> updateProduct(@PathVariable("id")int id,@RequestBody ProductDto productDto){
       ProductDto productDto1 =productService.updateProduct(id,productDto);
        return new ResponseEntity<>(productDto1,HttpStatus.OK);
    }

    @DeleteMapping("remove/{id}")
    private ResponseEntity<String> deleteProduct(@RequestParam("id") int id){
        boolean delete= productService.deleteProduct(id);
        if(delete){
            return new ResponseEntity<>("deleted",HttpStatus.OK);
        }else{
            return  new ResponseEntity<>("not found",HttpStatus.NOT_FOUND);
        }
    }
}
