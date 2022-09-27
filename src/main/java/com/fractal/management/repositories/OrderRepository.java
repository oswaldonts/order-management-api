package com.fractal.management.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.fractal.management.entities.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
    
    @Query(value="{number:'?0'}")
    List<Order> sortAllByNumber();
}
