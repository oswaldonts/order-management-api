package com.fractal.management.controllers;

import java.sql.Timestamp;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fractal.management.entities.Order;
import com.fractal.management.services.OrderService;

@CrossOrigin
@RestController
@RequestMapping(value = "api/orders")
public class OrderController {
    
    @Autowired
    private OrderService orderService;

    @GetMapping
    public Page<Order> getOrders(Pageable pageable) {
        return orderService.getOrders(pageable);
    }

    @GetMapping(value = "{id}")
    public Optional<Order> getOrder(@PathVariable String id) {
        return orderService.getOrder(id);
    }

    @PostMapping
    public Order saveOrder(@RequestBody Order order) {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        order.setCreatedAt(now);
        order.setUpdatedAt(now);

        return orderService.saveOrder(order);
    }

    @PutMapping(value = "{id}")
    public Order updateOrder(@PathVariable String id, @RequestBody Order order) {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        order.setUpdatedAt(now);

        return orderService.updateOrder(id, order);
    }

    @DeleteMapping(value = "{id}")
    public void deleteOrder(@PathVariable String id) {
        orderService.deleteOrder(id);
    }
}
