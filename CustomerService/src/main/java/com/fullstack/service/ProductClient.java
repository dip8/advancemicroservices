package com.fullstack.service;
import com.fullstack.vo.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "PRODUCTSERVICE", url = "http://localhost:9192/products/")
public interface ProductClient {
    @GetMapping("/findbyid/{productId}")
    public Product findById(@PathVariable long productId);
}
