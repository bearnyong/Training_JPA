package com.training.nyongcafe.Menu.dto;

import com.training.nyongcafe.Menu.entity.Category;

public class CategoryDTO {

    private int categoryCode; //카테고리코드
    private String categoryName; //카테고리명
    private Integer refCategoryCode; //상위카테고리코드(null값 가능)

    public CategoryDTO() {
    }

    public CategoryDTO(Category category) {
        this.categoryCode = category.getCategoryCode();
        this.categoryName = category.getCategoryName();
        this.refCategoryCode = category.getRefCategoryCode();
    }

    public CategoryDTO(int categoryCode, String categoryName, Integer refCategoryCode) {
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
        this.refCategoryCode = refCategoryCode;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getRefCategoryCode() {
        return refCategoryCode;
    }

    public void setRefCategoryCode(Integer refCategoryCode) {
        this.refCategoryCode = refCategoryCode;
    }

    @Override
    public String toString() {
        return "CategoryDTO{" +
                "categoryCode=" + categoryCode +
                ", categoryName='" + categoryName + '\'' +
                ", refCategoryCode=" + refCategoryCode +
                '}';
    }
}
