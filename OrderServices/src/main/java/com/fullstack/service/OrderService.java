package com.fullstack.service;

import com.fullstack.entity.Order;
import com.fullstack.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order save(Order order){
        return orderRepository.save(order);
    }

    @Cacheable(value = "orderId")
    public Optional<Order> findById (long orderId){
        return orderRepository.findById(orderId);
    }

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public Order update(Order order){
        return orderRepository.save(order);
    }

    public void deletedById(long orderId){
        orderRepository.deleteById(orderId);
    }
}
