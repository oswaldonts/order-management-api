package com.fractal.management.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fractal.management.dto.Taxes;
import com.fractal.management.entities.Order;
import com.fractal.management.entities.Product;
import com.fractal.management.repositories.OrderRepository;
import com.fractal.management.repositories.ProductRepository;

@Service
public class OrderService {
    
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    public Page<Order> getOrders(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

    public Optional<Order> getOrder(String id) {
        return orderRepository.findById(id);
    }

    public Order saveOrder(Order order) {
        Double subtotal = getSubtotal(order);
        Taxes taxes = calculateTaxes(subtotal);

        Double totalTaxes = taxes.getTotalTaxes();
        Double total = subtotal + totalTaxes;

        order.setTaxes(taxes);
        order.setTotalTaxes(totalTaxes);
        order.setTotal(total);

        return orderRepository.save(order);
    }

    public Order updateOrder(String id, Order order) {
        order.setId(id);

        return orderRepository.save(order);
    }

    public void deleteOrder(String id) {
        orderRepository.deleteById(id);
    }

    public Double getSubtotal(Order order) {
        Double subtotal = 0.00;

        List<String> productIds = order.getProducts();

        for (String productId : productIds) {
            Product product = productRepository.findById(productId).get();

            subtotal += product.getUnitPrice();
        }

        return subtotal;
    }

    public Taxes calculateTaxes(Double subtotal) {
        Double cityTaxPercentage = 0.10;
        Double countyTaxPercentage = 0.05;
        Double stateTaxPercentage = 0.08;
        Double federalTaxPercentage = 0.02;
        Double total = 0.00;

        Taxes taxes = new Taxes();

        total += subtotal;

        Double cityTax = total * cityTaxPercentage;
        total += cityTax;

        Double countyTax = total * countyTaxPercentage;
        total += countyTax;
        
        Double stateTax = total * stateTaxPercentage;
        total += stateTax;
        
        Double federalTax = total * federalTaxPercentage;
        total += federalTax;

        taxes.setCityTax(cityTax);
        taxes.setCountyTax(countyTax);
        taxes.setStateTax(stateTax);
        taxes.setFederalTax(federalTax);

        return taxes;
    }
}
