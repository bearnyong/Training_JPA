package com.training.nyongcafe.Order.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class OrderPK implements Serializable { //N
    //https://rachel0115.tistory.com/entry/JPA-%EB%B3%B5%ED%95%A9%ED%82%A4-%EB%A7%A4%ED%95%91%ED%95%98%EA%B8%B0-EmbeddedId-MapsId-isNew

    @Column(name = "order_code")
    private int orderCode; //주문코드(FK)

    @Column(name = "menu_code")
    private int menuCode; //메뉴코드(FK)

    public OrderPK() {

    }

    public OrderPK(int orderCode, int menuCode) {
        this.orderCode = orderCode;
        this.menuCode = menuCode;
    }

    public int getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(int orderCode) {
        this.orderCode = orderCode;
    }

    public int getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(int menuCode) {
        this.menuCode = menuCode;
    }

    @Override
    public String toString() {
        return "OrderMappingPK{" +
                "orderCode=" + orderCode +
                ", menuCode=" + menuCode +
                '}';
    }
}
