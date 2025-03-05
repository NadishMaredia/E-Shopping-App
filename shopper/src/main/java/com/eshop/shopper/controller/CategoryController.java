package com.eshop.shopper.controller;

import com.eshop.shopper.implementation.CategoryService;
import com.eshop.shopper.model.Category;
import com.eshop.shopper.service.ICategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {

    private ICategoryService categoryService;

    public CategoryController(ICategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping("/api/public/category")
    public ResponseEntity<List<Category>> getAllCategories(){
        List<Category> categoryList = this.categoryService.getAllCategories();
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @PostMapping("/api/public/category")
    public ResponseEntity<String> createCategory(@Valid @RequestBody Category category) {
        this.categoryService.createCategory(category);
        return new ResponseEntity<>("Category Added", HttpStatus.CREATED);
    }

    @DeleteMapping("/api/admin/category/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable()  Long categoryId) {
        String status = this.categoryService.deleteCategory(categoryId);
        return ResponseEntity.ok(status);
    }

    @PutMapping("/api/public/category/{categoryId}")
    public ResponseEntity<String> updateCategory(@Valid @RequestBody Category category, @PathVariable Long categoryId) {
        Category status = this.categoryService.updateCategory(category, categoryId);
        return ResponseEntity.ok("Category with id: " +categoryId +" updated");
    }
}
