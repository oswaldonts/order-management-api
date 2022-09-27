package com.fractal.management.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fractal.management.dto.Taxes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "orders")
public class Order {

    @Id
    private String id;
    private String number;
    private String status;
    private Date createdAt;
    private Date updatedAt;
    private String customer;
    private List<String> products;
    private Taxes taxes;
    private Double totalTaxes;
    private Double total;
}
