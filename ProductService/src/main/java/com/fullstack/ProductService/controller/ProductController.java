package com.fullstack.ProductService.controller;

import com.fullstack.ProductService.entity.Product;
import com.fullstack.ProductService.exception.RecordNotFoundException;
import com.fullstack.ProductService.service.ProductService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@Slf4j

public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/save")
    public ResponseEntity<Product> save(@Valid @RequestBody Product product){
        log.info("###### Trying to save data for Product"+product.getProductName());
        return ResponseEntity.ok(productService.save(product));
    }

    @GetMapping("/findbyid/{productId}")
    public ResponseEntity<Optional<Product>> findById(@PathVariable long productId){
        return ResponseEntity.ok(productService.findById(productId));
    }

    @GetMapping("/findbyname")
    public ResponseEntity<Product> findByName(@RequestParam(defaultValue = "Sony Smart TV",required = false) String productName){
        return ResponseEntity.ok(productService.findByName(productName));
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Product>> findAll(){
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/sortbyname")
    public ResponseEntity<List<Product>> sortByName(){
        return ResponseEntity.ok(productService.findAll().stream().sorted(Comparator.comparing(Product::getProductName).reversed()).toList());
    }

    @GetMapping("/sortbyprice")
    public ResponseEntity<List<Product>> sortByPrice(){
        return ResponseEntity.ok(productService.findAll().stream().sorted(Comparator.comparing(Product::getProductPrice).reversed()).toList());
    }

    @PutMapping("/update/{productId}")
    public ResponseEntity<Product> update(@PathVariable long productId, @Valid @RequestBody Product product){
        Product product1 = productService.findById(productId).orElseThrow(()-> new RecordNotFoundException("Product Id Does Not Exist"));

        product1.setProductName(product.getProductName());
        product1.setProductPrice(product.getProductPrice());
        product1.setProductLunchDate(product.getProductLunchDate());

        return ResponseEntity.ok(productService.update(product1));
    }

    @PatchMapping("/changeproductprice/{productId}/{productPrice}")
    public ResponseEntity<Product> changePrice(@PathVariable long productId, @PathVariable double productPrice){
        Product product1 = productService.findById(productId).orElseThrow(()-> new RecordNotFoundException("Product Id Does Not Exist"));

        product1.setProductPrice(productPrice);

        return ResponseEntity.ok(productService.update(product1));
    }
    
    @DeleteMapping("/deletebyid/{productId}")
    public ResponseEntity<String> deleteById(@PathVariable long productId){
        productService.deleteById(productId);
        return ResponseEntity.ok("Product Data Deleted");
    }
}