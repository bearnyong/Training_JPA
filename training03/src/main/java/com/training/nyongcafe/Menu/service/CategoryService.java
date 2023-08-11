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

    public List<Category> readAllCategorys() { //01_전체조회(GET)
        List<Category> categoryList = categoryRepository.findAll();

        return categoryList;
    }

    public Category readOneCategory(int categoryCode) { //02_부분조회(GET)
        Category category = categoryRepository.findById(categoryCode);
        return category;
    }
}
