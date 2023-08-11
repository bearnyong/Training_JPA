package com.training.nyongcafe.Menu.service;

import com.training.nyongcafe.Menu.entity.Category;
import com.training.nyongcafe.Menu.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> readAllCategorys() {
        List<Category> categoryList = categoryRepository.findAll();

        return categoryList;
    }
}
