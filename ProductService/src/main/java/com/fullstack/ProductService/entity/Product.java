package com.fullstack.ProductService.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor@NoArgsConstructor
@Entity
@Table(name="PRODUCT")

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;

    @Size(min=2, message = "Product Name should be at least 2 characters")
    private String productName;

    private double productPrice;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date productLunchDate;
}
