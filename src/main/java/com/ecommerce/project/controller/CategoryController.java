package com.ecommerce.project.controller;

import com.ecommerce.project.model.Category;
import com.ecommerce.project.payload.CategoryDTO;
import com.ecommerce.project.payload.CategoryResponse;
import com.ecommerce.project.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/public/categories")
    public ResponseEntity<CategoryResponse> getCategories() {
        CategoryResponse categoryResponse = categoryService.getAllCategories();
        return  new ResponseEntity<>(categoryResponse,HttpStatus.OK);
    }

    @PostMapping("/public/categories")
    public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
        CategoryDTO savedCategpryDTO = categoryService.createCategory(categoryDTO);
        return new  ResponseEntity<>(savedCategpryDTO, HttpStatus.CREATED);
     }


    @DeleteMapping("/admin/categories/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId) {
        // Path Variable bir HTTP isteği sırasında URI'nin belirli bir bölümünden veri alınmasını sağlar.

            String status = categoryService.deleteCategory(categoryId);
            return  ResponseEntity.status(HttpStatus.OK).body(status);

    }

    @PutMapping("/public/categories/{categoryId}")
    public ResponseEntity<String> updateCategory(@Valid @RequestBody Category category, @PathVariable Long categoryId) {

            Category savedCategory = categoryService.updateCategory(category,categoryId);
            return  new ResponseEntity<>("Updated Category with category id : " + categoryId,HttpStatus.OK);
    }

}
