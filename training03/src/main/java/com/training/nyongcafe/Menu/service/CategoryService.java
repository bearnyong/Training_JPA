package com.training.nyongcafe.Menu.service;

import com.training.nyongcafe.Menu.dto.CategoryDTO;
import com.training.nyongcafe.Menu.entity.Category;
import com.training.nyongcafe.Menu.repository.CategoryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

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

    @Transactional
    public int insertOneCategory(Category category) { //03_카테고리등록(POST)
        Category result = categoryRepository.save(category);
        if (Objects.isNull(result)) {
            return 0;
        } else {
            return 1;
        }
    }
}
