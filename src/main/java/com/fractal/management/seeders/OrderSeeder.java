package com.fractal.management.seeders;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fractal.management.dto.Taxes;
import com.fractal.management.entities.Order;
import com.fractal.management.repositories.OrderRepository;

@Component
public class OrderSeeder implements CommandLineRunner {
    
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        if (orderRepository.findAll().size() == 0) {
            String[] number = {
                "askjdlas",
                "ajdkals",
                "nbmnbsd",
                "9808",
            };

            String[] status = {
                "Pending",
                "Completed",
                "Rejected",
                "Completed",
            };

            String[] customer = {
                "Joe Smith",
                "Joe Baker",
                "Joe Adams",
                "Joseph Evans",
            };

            List<String> pList = new ArrayList<>();
            pList.add("Cookies");
            pList.add("Candies");
            pList.add("Cakes");
            pList.add("Desserts");

            Taxes taxes = new Taxes(2.05, 4.10, 6.15, 8.20);

            Double[] totalTaxes = {
                27.23,
                5.00,
                40.50,
                13.00,
            };

            Double[] total = {
                127.23,
                50.00,
                200.50,
                100.00,
            };

            for (int i = 0; i < total.length; i++) {
                Order order = new Order();
                order.setNumber(number[i]);
                order.setStatus(status[i]);
                order.setCreatedAt(new Timestamp(System.currentTimeMillis()));
                order.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
                order.setCustomer(customer[i]);
                order.setProducts(pList);
                order.setTaxes(taxes);
                order.setTotalTaxes(totalTaxes[i]);
                order.setTotal(total[i]);

                orderRepository.save(order);
            }
        }
    }
}
