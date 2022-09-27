package com.fractal.management.seeders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fractal.management.entities.Status;
import com.fractal.management.repositories.StatusRepository;

@Component
public class StatusSeeder implements CommandLineRunner {

    @Autowired
    private StatusRepository statusRepository;
    
    @Override
    public void run(String... args) throws Exception {
        if (statusRepository.findAll().size() == 0) {
            String[] names = {
                "Pending",
                "Completed",
                "Rejected",
            };
    
            for (String name : names) {
                Status status = new Status();
                status.setName(name);
    
                statusRepository.save(status);
            }
        }
    }
}
