package com.fractal.management.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fractal.management.entities.Category;
import com.fractal.management.repositories.CategoryRepository;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;

    public Page<Category> getCategories(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    public Optional<Category> getCategory(String id) {
        return categoryRepository.findById(id);
    }

    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category updateCategory(String id, Category category) {
        category.setId(id);
        
        return categoryRepository.save(category);
    }
}
