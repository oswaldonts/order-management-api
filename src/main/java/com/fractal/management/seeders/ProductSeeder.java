package com.fractal.management.seeders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fractal.management.entities.Product;
import com.fractal.management.repositories.ProductRepository;

@Component
public class ProductSeeder implements CommandLineRunner {
    
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        if (productRepository.findAll().size() == 0) {
            String[] name = {
                "Cookie",
                "Candy",
                "Cake",
                "Dessert",
            };

            String[] category = {
                "Cookies",
                "Candies",
                "Cakes",
                "Desserts",
            };

            Double[] unitPrice = {
                25.00,
                25.00,
                25.00,
                25.00,
            };

            Boolean[] active = {
                true,
                true,
                true,
                true,
            };

            for (int i = 0; i < active.length; i++) {
                Product product = new Product();
                product.setId(name[i]);
                product.setName(name[i]);
                product.setCategory(category[i]);
                product.setUnitPrice(unitPrice[i]);
                product.setActive(active[i]);

                productRepository.save(product);
            }
        }
    }
}
