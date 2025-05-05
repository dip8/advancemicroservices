package com.fullstack.vo;

import com.fullstack.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ResponseVO {

    private Customer customer;

    private Product product;

    private Order order;
}
