package com.fullstack.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;
import org.springframework.cache.annotation.EnableCaching;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="CUSTOMER")

public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long custId;

    @Size(min = 2, message ="Name should be atleast 2 characters")
    private String custName;

    private String custAddress;

    @Range(min = 1000000000, max = 9999999999L, message = "Contact Number Must be 10 Digit")
    private long custContactNumber;

    @Email(message = "Email ID must be valid")
    private String custEmailId;

    @Size(min = 4, message = "Password should be 4 characters")
    private String custPassword;

    private long orderId;

    private long productId;
}