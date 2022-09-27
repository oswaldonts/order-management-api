package com.fractal.management.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fractal.management.entities.Status;
import com.fractal.management.services.StatusService;

@RestController
@RequestMapping(value = "api/statuses")
public class StatusController {
    
    @Autowired
    private StatusService statusService;

    @GetMapping
    public List<Status> getStatuses() {
        return statusService.getStatuses();
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

    @DeleteMapping(value = "{id}")
    public void deleteStatus(@PathVariable String id) {
        statusService.deleteStatus(id);
    }
}
