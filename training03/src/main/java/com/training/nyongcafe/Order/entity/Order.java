package com.training.nyongcafe.Order.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_order")
public class Order {

    @Id
    @Column(name = "order_code")
    private int orderCode; //주문코드

    @Column(name = "order_date") //?
    private String orderDate; //주문일자

    @Column(name = "order_time") //?
    private String orederTime; //주문시간

    @Column(name = "total_order_price")
    private int totalOrderPrice; //총주문금액


}
