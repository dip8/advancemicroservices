package com.fullstack.repository;

import com.fullstack.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByCustName(String custName);

    Customer findByCustEmailIdAndCustPassword(String custEmail, String custPassword);
}
