package com.training.nyongcafe.Menu.entity;

import com.training.nyongcafe.Menu.dto.MenuDTO;

import javax.persistence.*;

@Entity
@Table(name = "tbl_menu")
public class Menu { //N

    @Id
    @Column(name = "menu_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //데이터베이스에서 관리하는 전략 사용
    private int menuCode; //메뉴코드

    @Column(name = "menu_name")
    private String menuName; //메뉴명

    @Column(name = "menu_price")
    private int menuPrice; //메뉴가격

    @Column(name = "orderable_status")
    private String orderableStatus; //주문가능상태

//    @MapsId("category_code")
    @ManyToOne //연관관계 매핑 -> setter로 연관관계 설정
    @JoinColumn(name = "category_code")
    private Category category;
    /* 1. 양방향은 외래 키가 있는 쪽이 연관관계의 주인이다.
     * -- 일대다와 다대일 연관관계는 항상 다(N)에 외래 키가 있다.
     * -- JPA는 외래 키를 관리할 때 연관ㄱ관계의 주인만 사용한다.
     *
     * 2. 양방향 연관관계는 항상 서로를 참조해야 한다.
     * -- 어느 한 쪽만 참조하면 양방향 연관관계가 성립하지 않는다.*/

    public Menu() {
    }

    public Menu(MenuDTO menuDTO) {
        this.menuCode = menuDTO.getMenuCode();
        this.menuName = menuDTO.getMenuName();
        this.menuPrice = menuDTO.getMenuPrice();
        this.orderableStatus = menuDTO.getOrderableStatus();
    }

    public Menu(int menuCode, String menuName, int menuPrice, String orderableStatus, Category category) {
        this.menuCode = menuCode;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.orderableStatus = orderableStatus;
        this.category = category;
    }

    /*Getter, Setter*/
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

    public String getOrderableStatus() {
        return orderableStatus;
    }

    public void setOrderableStatus(String orderableStatus) {
        this.orderableStatus = orderableStatus;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) { //연관관계 설정
        this.category = category;
        if (!category.getMenuList().contains(this)) {
            //무한루프에 빠지지 않도록 체크
            category.getMenuList().add(this);
        }
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuCode=" + menuCode +
                ", menuName='" + menuName + '\'' +
                ", menuPrice=" + menuPrice +
                ", orderableStatus='" + orderableStatus + '\'' +
                ", category_code=" + category.getCategoryCode() +
                '}';
    }
}
