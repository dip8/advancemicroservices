package com.fullstack.service;

import com.fullstack.entity.Customer;
import com.fullstack.repository.CustomerRepository;
import com.fullstack.vo.Order;
import com.fullstack.vo.Product;
import com.fullstack.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderClient orderClient;

    @Autowired
    private ProductClient productClient;

    public Customer save(Customer customer){
        return customerRepository.save(customer);
    }

    public boolean signIn(String custEmailId, String custPassword){
        boolean flag = false;

        Customer customer = customerRepository.findByCustEmailIdAndCustPassword(custEmailId,  custPassword);

        if(customer!=null){
            flag=true;
        }
        return flag;
    }

    public ResponseVO findById(long custId){

        ResponseVO responseVO =new ResponseVO();
        Customer customer = customerRepository.findById(custId).get();
        Product product = productClient.findById(customer.getOrderId());
        Order order = orderClient.findById(customer.getOrderId());

        responseVO.setCustomer(customer);
        responseVO.setProduct(product);
        responseVO.setOrder(order);

        return responseVO;
    }

    public List<Customer> findByName(String custName){
        return customerRepository.findByCustName(custName);
    }

    public List<Customer> findAll(){
        return customerRepository.findAll();
    }

    public Customer update (Customer customer){
        return customerRepository.save(customer);
    }

    public void deleteById(long custId){
        customerRepository.deleteById(custId);
    }
}
