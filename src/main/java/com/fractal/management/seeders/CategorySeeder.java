package com.fractal.management.seeders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fractal.management.entities.Category;
import com.fractal.management.repositories.CategoryRepository;

@Component
public class CategorySeeder implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        if (categoryRepository.findAll().size() == 0) {
            String[] names = {
                "Cookies",
                "Candies",
                "Cakes",
                "Desserts",
                "Drinks",
            };

            for (String name : names) {
                Category category = new Category();
                category.setName(name);

                categoryRepository.save(category);
            }
        }
    }
}
