package com.fractal.management.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fractal.management.entities.Status;
import com.fractal.management.repositories.StatusRepository;

@Service
public class StatusService {
    
    @Autowired
    private StatusRepository statusRepository;

    public Page<Status> getStatuses(Pageable pageable) {
        return statusRepository.findAll(pageable);
    }

    public Optional<Status> getStatus(String id) {
        return statusRepository.findById(id);
    }

    public Status saveStatus(Status status) {
        return statusRepository.save(status);
    }

    public Status updateStatus(String id, Status status) {
        status.setId(id);

        return statusRepository.save(status);
    }
}
