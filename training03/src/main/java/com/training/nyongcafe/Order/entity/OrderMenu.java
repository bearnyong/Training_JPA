package com.training.nyongcafe.Order.entity;

import com.training.nyongcafe.Menu.entity.Menu;

import javax.persistence.*;

@Entity
@Table(name = "tbl_order_menu")
public class OrderMenu {

    @EmbeddedId
    private OrderPK orderPK; //주문코드, 메뉴코드

    @MapsId("orderCode") //필드명
    @ManyToOne
    @JoinColumn(name = "order_code")
    private Order order;

    @MapsId("menuCode") //필드명
    @ManyToOne
    @JoinColumn(name = "menu_code")
    private Menu menu;

    @Column(name = "order_amount")
    private int orderAmount; //주문수량

}
