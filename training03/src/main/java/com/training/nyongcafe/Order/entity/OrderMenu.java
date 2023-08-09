package com.training.nyongcafe.Order.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_order_menu")
public class OrderMenu {

    @EmbeddedId
    private OrderPK orderPK; //주문코드, 메뉴코드

    @Column(name = "order_amount")
    private int orderAmount; //주문수량
}
