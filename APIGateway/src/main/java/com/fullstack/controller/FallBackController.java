package com.fullstack.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")

public class FallBackController {
     @GetMapping("/customerfallback")
     public ResponseEntity<String> customerFallBack(){
          return ResponseEntity.ok("Customer Service is down Please wait!........");
     }

     @GetMapping("/productfallback")
     public ResponseEntity<String> productFallBack(){
          return ResponseEntity.ok("Product Service is down Please wait!........");
     }

     @GetMapping("/orderfallback")
     public ResponseEntity<String> orderFallBack(){
          return ResponseEntity.ok("Order Service is down Please wait!........");
     }
}
