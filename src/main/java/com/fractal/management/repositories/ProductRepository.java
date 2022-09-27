package com.fractal.management.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fractal.management.entities.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    
}
