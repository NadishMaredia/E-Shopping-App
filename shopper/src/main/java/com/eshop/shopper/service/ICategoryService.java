package com.eshop.shopper.service;

import com.eshop.shopper.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> getAllCategories();
    void createCategory(Category category);
    String deleteCategory(Long categoryId);

    Category updateCategory(Category category, Long categoryId);
}
