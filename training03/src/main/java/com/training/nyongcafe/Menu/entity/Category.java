package com.training.nyongcafe.Menu.entity;

import com.training.nyongcafe.Menu.dto.CategoryDTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_category")
public class Category { //1

    @Id
    @Column(name = "category_code")
    private int categoryCode; //카테고리코드

    @Column(name = "category_name")
    private String categoryName; //카테고리명

    @Column(name = "ref_category_code")
    private Integer refCategoryCode; //상위카테고리코드(null값 가능)

    @OneToMany(mappedBy = "category") //반대편 필드에 적힌 이름...
    //연관관계의 주인 정하기... 양뱡향 관계에서 주체가 되는 쪽(Many쪽, 외래키가 있는 쪽)을 정의
    private List<Menu> menuList = new ArrayList<Menu>(); //연관관계에 대한 정보 관리
    /* 일대다 단방향 매핑의 단점
     * 매핑한 객체가 관리하는 외래 키가 다른 테이블에 있다는 점...
     * 본인 테이블에 외래 키가 있으면 엔티티의 저장과 연관관계 처리를 INSERT SQL 한 번으로 끝낼 수 있지만
     * 다른 테이블에 외래 키가 있으면 연관관계처리를 위한 update sql을 추가로 실행해야 한다. */
    public void addMenu(Menu menu) {
        this.menuList.add(menu);
        if (menu.getCategory() != this) { //무한루프에 빠지지 않도록 체크
            menu.setCategory(this);
        }
    }

    public Category() {
    }

    public Category(CategoryDTO categoryDTO) {
        this.categoryCode = categoryDTO.getCategoryCode();
        this.categoryName = categoryDTO.getCategoryName();
        this.refCategoryCode = categoryDTO.getRefCategoryCode();
    }

    public Category(int categoryCode, String categoryName, Integer refCategoryCode, List<Menu> menuList) {
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
        this.refCategoryCode = refCategoryCode;
        this.menuList = menuList;
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
        return new Category(categoryCode, categoryName, refCategoryCode, menuList);
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

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryCode=" + categoryCode +
                ", categoryName='" + categoryName + '\'' +
                ", refCategoryCode=" + refCategoryCode +
                ", menuList=" + menuList +
                '}';
    }
}
