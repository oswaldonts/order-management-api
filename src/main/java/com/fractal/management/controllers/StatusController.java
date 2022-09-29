package com.fractal.management.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fractal.management.entities.Status;
import com.fractal.management.services.StatusService;

@CrossOrigin
@RestController
@RequestMapping(value = "api/statuses")
public class StatusController {
    
    @Autowired
    private StatusService statusService;

    @GetMapping
    public Page<Status> getStatuses(Pageable pageable) {
        return statusService.getStatuses(pageable);
    }

    @GetMapping(value = "{id}")
    public Optional<Status> getStatus(@PathVariable String id) {
        return statusService.getStatus(id);
    }

    @PostMapping
    public Status saveStatus(@RequestBody Status status) {
        return statusService.saveStatus(status);
    }

    @PutMapping(value = "{id}")
    public Status updateStatus(@PathVariable String id, @RequestBody Status status) {
        return statusService.updateStatus(id, status);
    }
}
