package com.fullstack.controller;

import com.fullstack.entity.Order;
import com.fullstack.exception.RecordNotFoundException;
import com.fullstack.service.OrderService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/save")
    public ResponseEntity<Order> save(@Valid @RequestBody Order order){
        log.info("######Order Details:"+ order.getOrderDescription());
        return ResponseEntity.ok(orderService.save(order));
    }

    @GetMapping("/findbyid/{orderId}")
    public ResponseEntity<Optional<Order>> findById(@PathVariable long orderId){
        return ResponseEntity.ok(orderService.findById(orderId));
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Order>> findAll(){
        return ResponseEntity.ok(orderService.findAll());
    }

    @PutMapping("/update/{orderId}")
    public ResponseEntity<Order> update(@PathVariable long orderId, @RequestBody Order order){
        Order order1=orderService.findById(orderId).orElseThrow(()-> new RecordNotFoundException("Order Id Does Not Exist"));
        order1.setOrderDescription(order.getOrderDescription());
        order1.setOrderDate(order.getOrderDate());

        return ResponseEntity.ok(orderService.update(order1));
    }

    @DeleteMapping("/deletebyid/{orderId}")
    public ResponseEntity<String> deleteById(@PathVariable long orderId){
        orderService.deletedById(orderId);
        return ResponseEntity.ok("Order Data Deleted Successfully");
    }
}
