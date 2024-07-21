package com.ecommerce.project.service;

import com.ecommerce.project.model.Category;
import com.ecommerce.project.repositories.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
   // private List<Category> categories = new ArrayList<>();
    private Long nextId = 1L;

    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void createCategory(Category category) {
        category.setCategoryId(nextId++);
        categoryRepository.save(category);
    }

    @Override
    public String  deleteCategory(Long categoryId) {
        List<Category> categories = categoryRepository.findAll();
        Category category = categories.stream().filter(c->c.getCategoryId().equals(categoryId))
                .findFirst().
                orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Resource Not Found"));
        //Stream API'si, koleksiyonlar (List, Set, Map gibi) veya diziler üzerinde ardışık işlemler
        // yapmayı sağlayan bir yapıdır

        categoryRepository.delete(category);
        return "Category with categoryId: " + categoryId + " deleted";

    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {
        List<Category> categories = categoryRepository.findAll();
        Optional<Category> optionalCategory =
                categories.stream().filter(c->c.getCategoryId().equals(categoryId))
                .findFirst();

        //Optional sınıfı, null referansları daha güvenli bir şekilde yönetmek için kullanılır.

        if (optionalCategory.isPresent()){
            Category existingCategory = optionalCategory.get();
            existingCategory.setCategoryName(category.getCategoryName());
            Category savedCategory = categoryRepository.save(existingCategory);
            return savedCategory;
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Resource Not Found");
        }

    }
}
