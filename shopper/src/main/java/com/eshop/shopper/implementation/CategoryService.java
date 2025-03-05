package com.eshop.shopper.implementation;

import com.eshop.shopper.exceptions.APIException;
import com.eshop.shopper.exceptions.ResourceNotFoundException;
import com.eshop.shopper.model.Category;
import com.eshop.shopper.repository.ICategoryRepository;
import com.eshop.shopper.service.ICategoryService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryRepository categoryRepository;
    @Override
    public List<Category> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        if(categories.isEmpty()) throw new APIException("No category created till now");
        return categories;
    }

    @Override
    public void createCategory(Category category) {
        Category savedCategory = categoryRepository.findByCategoryName(category.getCategoryName());
        if(savedCategory != null) throw new APIException("Category with the name " +category.getCategoryName() + " already exists");
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId)) ;

        categoryRepository.delete(category);

        return "Category Deleted";
    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {
        Optional<Category> categories = categoryRepository.findById(categoryId);

        Category savedCategory = categories.orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));
        savedCategory.setCategoryId(categoryId);

        savedCategory = categoryRepository.save(savedCategory);
        return savedCategory;

    }
}
