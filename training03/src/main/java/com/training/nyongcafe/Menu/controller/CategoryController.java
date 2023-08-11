package com.training.nyongcafe.Menu.controller;

import com.training.nyongcafe.Menu.dto.CategoryDTO;
import com.training.nyongcafe.Menu.entity.Category;
import com.training.nyongcafe.Menu.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
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

    @GetMapping("/read/{categoryCode}") //02_부분조회(GET)
    public ResponseEntity<?> readOneCategory(@PathVariable int categoryCode) {
        Category category = categoryService.readOneCategory(categoryCode);
        if (Objects.isNull(category)) {
            return ResponseEntity.status(404).body("존재하지 않는 categoryCode 입니다...");
        } else {
            CategoryDTO categoryDTO = new CategoryDTO(category);
            return ResponseEntity.ok().body(categoryDTO);
        }
    }

    @PostMapping("/insert")
    public ResponseEntity<?> insertOneCategory(CategoryDTO categoryDTO) { //03_카테고리등록(POST)
        Category category = new Category(categoryDTO);

        int result = categoryService.insertOneCategory(category);
        if (result == 0) {
            return ResponseEntity.status(404).body("카테고리 등록에 실패하였습니다...");
        } else {
            return ResponseEntity.ok().body("카테고리: " + category.getCategoryName() + " (이)가 등록되었습니다.");
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateOneCategory(CategoryDTO categoryDTO) { //04_카테고리수정(PUT)
        Category findCategory = categoryService.readOneCategory(categoryDTO.getCategoryCode());
        if (Objects.isNull(findCategory)) {
            return ResponseEntity.ok().body("해당 카테고리가 존재하지 않습니다...");
        }

        int result = categoryService.updateCategory(findCategory, categoryDTO);
        if (result == 0) {
            return ResponseEntity.status(404).body("카테고리 수정에 실패하였습니다...");
        } else {
            return ResponseEntity.ok().body(categoryDTO.getCategoryCode() + "번 카테고리가 수정되었습니다.");
        }
    }

    @DeleteMapping("/{deleteCategoryCode}")
    public ResponseEntity<?> deleteOneCategory(@PathVariable int deleteCategoryCode) { //05_카테고리삭제(DELETE)
        categoryService.deleteOneCategory(deleteCategoryCode);

        return ResponseEntity.ok().body(deleteCategoryCode + "번 카테고리 삭제 완료");
    }
}
