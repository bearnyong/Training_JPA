package com.training.nyongcafe.Menu.controller;

import com.training.nyongcafe.Menu.dto.CategoryDTO;
import com.training.nyongcafe.Menu.entity.Category;
import com.training.nyongcafe.Menu.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categorys") //도메인
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        /* bean에서 등록될 수 있도록 설정 */
        this.categoryService = categoryService;
    }

    @GetMapping("/read/list") //01_전체조회(GET)
    public ResponseEntity<List<?>> readAllCategorys() {
        List<Category> categoryList = categoryService.readAllCategorys();
        if (categoryList.size() <= 0) {
            return ResponseEntity.status(404).body(Collections.singletonList("error"));
        } else {
            List<CategoryDTO> categoryDTOList = categoryList.stream().map(category -> new CategoryDTO(category)).collect(Collectors.toList());
            return ResponseEntity.ok().body(categoryDTOList);
        }
    }
}
