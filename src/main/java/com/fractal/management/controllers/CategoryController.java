package com.fractal.management.controllers;

import java.util.Optional;

import javax.validation.Valid;

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

import com.fractal.management.entities.Category;
import com.fractal.management.services.CategoryService;

@CrossOrigin
@RestController
@RequestMapping(value = "api/categories")
public class CategoryController {
    
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public Page<Category> getCategories(Pageable pageable) {
        return categoryService.getCategories(pageable);
    }

    @GetMapping(value = "{id}")
    public Optional<Category> getCategory(@PathVariable String id) {
        return categoryService.getCategory(id);
    }

    @PostMapping
    public Category saveCategory(@RequestBody @Valid Category category) {
        return categoryService.saveCategory(category);
    }

    @PutMapping(value = "{id}")
    public Category updateCategory(@PathVariable String id, @RequestBody Category category) {
        return categoryService.updateCategory(id, category);
    }
}
