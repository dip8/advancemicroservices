package com.fullstack.ProductService.service;

import com.fullstack.ProductService.entity.Product;
import com.fullstack.ProductService.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product save(Product product){
        return productRepository.save(product);
    }

    @Cacheable(value = "productId")
    public Optional<Product> findById(long productId){
        log.info("##### Try to fetch from DB");
        return productRepository.findById(productId);
    }

    public Product findByName(String productName){
        return productRepository.findByProductName(productName);
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product update(Product product){
        return productRepository.save(product);
    }

    public void deleteById(long productId){
        productRepository.deleteById(productId);
    }
}
