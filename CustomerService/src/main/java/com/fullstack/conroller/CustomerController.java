package com.fullstack.conroller;

import com.fullstack.entity.Customer;
import com.fullstack.exception.RecordNotFoundException;
import com.fullstack.repository.CustomerRepository;
import com.fullstack.service.CustomerService;
import com.fullstack.vo.ResponseVO;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@Slf4j

public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/save")
    public ResponseEntity<Customer> save(@RequestBody @Valid Customer customer){
        log.info("##### Trying to save data for Customer:"+ customer.getCustName());
        return ResponseEntity.ok(customerService.save(customer));
    }

    @GetMapping("/signin/{custEmailId}/{custPassword}")
    public ResponseEntity<Boolean> signIn(@PathVariable String custEmailId, @PathVariable String custPassword) {
        return ResponseEntity.ok(customerService.signIn(custEmailId, custPassword));
    }

    @GetMapping("/findbyid/{custId}")
    public ResponseEntity<ResponseVO> findById(@PathVariable long custId){
        return ResponseEntity.ok(customerService.findById(custId));
    }

    @GetMapping("/findbyname")
    public ResponseEntity<List<Customer>> findByName(@RequestParam(defaultValue = "Swara", required = false) String custName){
        return ResponseEntity.ok(customerService.findByName(custName));
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Customer>> findAll(){
        return ResponseEntity.ok(customerService.findAll());
    }

    @PutMapping("/update/{custId}")
    public ResponseEntity<Customer> update(@PathVariable long custId, @Valid @RequestBody Customer customer){
        Customer customer1 = customerRepository.findById(custId).orElseThrow(()-> new RecordNotFoundException("Customer Id Does Not Exist"));

        customer1.setCustName(customer.getCustName());
        customer1.setCustAddress(customer.getCustAddress());
        customer1.setCustContactNumber(customer.getCustContactNumber());
        customer1.setCustEmailId(customer.getCustEmailId());
        customer1.setCustPassword(customer.getCustPassword());

        return ResponseEntity.ok(customerService.update(customer1));
    }

    @DeleteMapping("/deletedbyid/{custId}")
    public ResponseEntity<String> deleteById(@PathVariable long custId){
        customerService.deleteById(custId);
        return ResponseEntity.ok("Customer Data Deleted Successfully");
    }
}
