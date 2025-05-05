package com.fullstack.service;

import com.fullstack.vo.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ORDERSERVICE", url = "http://localhost:9191/orders/")
public interface OrderClient {
    @GetMapping("/findbyid/{orderId}")
    public Order findById(@PathVariable long orderId);
}
