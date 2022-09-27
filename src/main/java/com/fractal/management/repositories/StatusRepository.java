package com.fractal.management.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fractal.management.entities.Status;

@Repository
public interface StatusRepository extends MongoRepository<Status, String> {
    
}
