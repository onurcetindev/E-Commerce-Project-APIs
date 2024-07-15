package com.ecommerce.project.controller;

import com.ecommerce.project.model.Category;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {

    private List<Category> categories = new ArrayList<>();

    @GetMapping("/api/public/categories")
    public List<Category> getCategories() {
        return categories;
    }

    @PostMapping("/api/public/categories")
    public String createCategory(@RequestBody Category category) {
        categories.add(category);
        return "Category added successfully";
    }

    @DeleteMapping("/api/public/categories")
    public String deleteCategory(@RequestBody Category category) {
        categories.remove(category);
        return "Category deleted successfully";
    }

}
