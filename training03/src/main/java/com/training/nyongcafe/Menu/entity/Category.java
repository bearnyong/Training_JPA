package com.training.nyongcafe.Menu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_category")
public class Category {

    @Id
    @Column(name = "category_code")
    private int categoryCode; //카테고리코드

    @Column(name = "category_name")
    private String categoryName; //카테고리명

    @Column(name = "ref_category_code")
    private Integer refCategoryCode; //상위카테고리코드(null값 가능)

    public Category() {
    }

    public Category(int categoryCode, String categoryName, Integer refCategoryCode) {
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
        this.refCategoryCode = refCategoryCode;
    }

    /*Builder 패턴*/
    public Category categoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
        return this;
    }

    public Category categoryName(String categoryName) {
        this.categoryName = categoryName;
        return this;
    }

    public Category refCategoryCode(Integer refCategoryCode) {
        this.refCategoryCode = refCategoryCode;
        return this;
    }

    public Category builder() {
        return new Category(categoryCode, categoryName, refCategoryCode);
    }

    /*Getter, Setter*/
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
        return "Category{" +
                "categoryCode=" + categoryCode +
                ", categoryName='" + categoryName + '\'' +
                ", refCategoryCode=" + refCategoryCode +
                '}';
    }
}
