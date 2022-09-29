package com.fractal.management.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fractal.management.entities.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {

}
