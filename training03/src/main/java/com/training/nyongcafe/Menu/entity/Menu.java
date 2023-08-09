package com.training.nyongcafe.Menu.entity;

import com.training.nyongcafe.Menu.dto.MenuDTO;

import javax.persistence.*;

@Entity
@Table(name = "tbl_menu")
public class Menu {

    @Id
    @Column(name = "menu_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //데이터베이스에서 관리하는 전략 사용
    private int menuCode; //메뉴코드

    @Column(name = "menu_name")
    private String menuName; //메뉴명

    @Column(name = "menu_price")
    private int menuPrice; //메뉴가격

    @Column(name = "category_code")
    private int categoryCode; //카테고리코드(FK)

    @Column(name = "orderable_status")
    private String orderableStatus; //주문가능상태

    public Menu() {
    }

    public Menu(MenuDTO menuDTO) { //MenuDTO를 Menu entity에 한 번에 담아주기 위해 생성
        this.menuCode = menuDTO.getMenuCode();
        this.menuName = menuDTO.getMenuName();
        this.menuPrice = menuDTO.getMenuPrice();
        this.categoryCode = menuDTO.getCategoryCode();
        this.orderableStatus = menuDTO.getOrderableStatus();
    }

    public Menu(int menuCode, String menuName, int menuPrice, int categoryCode, String orderableStatus) {
        this.menuCode = menuCode;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.categoryCode = categoryCode;
        this.orderableStatus = orderableStatus;
    }

    public int getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(int menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(int menuPrice) {
        this.menuPrice = menuPrice;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getOrderableStatus() {
        return orderableStatus;
    }

    public void setOrderableStatus(String orderableStatus) {
        this.orderableStatus = orderableStatus;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuCode=" + menuCode +
                ", menuName='" + menuName + '\'' +
                ", menuPrice=" + menuPrice +
                ", categoryCode=" + categoryCode +
                ", orderableStatus='" + orderableStatus + '\'' +
                '}';
    }
}
