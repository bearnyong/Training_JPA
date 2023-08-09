package com.training.nyongcafe.Menu.dto;

import com.training.nyongcafe.Menu.entity.Menu;

public class MenuDTO {

    private int menuCode; //메뉴코드
    private String menuName; //메뉴명
    private int menuPrice; //메뉴가격
    private int categoryCode; //카테고리코드(FK)
    private String orderableStatus; //주문가능상태

    public MenuDTO() {
    }

    public MenuDTO(Menu menu) { //Menu entity를 MenuDTO에 한 번에 담아주기 위해 생성
        this.menuCode = menu.getMenuCode();
        this.menuName = menu.getMenuName();
        this.menuPrice = menu.getMenuPrice();
        this.categoryCode = menu.getCategoryCode();
        this.orderableStatus = menu.getOrderableStatus();
    }

    public MenuDTO(int menuCode, String menuName, int menuPrice, int categoryCode, String orderableStatus) {
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
        return "MenuDTO{" +
                "menuCode=" + menuCode +
                ", menuName='" + menuName + '\'' +
                ", menuPrice=" + menuPrice +
                ", categoryCode=" + categoryCode +
                ", orderableStatus='" + orderableStatus + '\'' +
                '}';
    }
}
