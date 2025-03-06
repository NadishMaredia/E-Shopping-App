package com.eshop.shopper.service;

import com.eshop.shopper.model.Category;
import com.eshop.shopper.payload.CategoryDTO;
import com.eshop.shopper.payload.CategoryResponse;

import java.util.List;

public interface ICategoryService {
    CategoryResponse getAllCategories(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);
    CategoryDTO createCategory(CategoryDTO categoryDTO);
    CategoryDTO deleteCategory(Long categoryId);

    CategoryDTO updateCategory(CategoryDTO categoryDTO, Long categoryId);
}
