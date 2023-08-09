package com.training.nyongcafe.Order.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class OrderPK implements Serializable {

    @Column(name = "order_code")
    private int orderCode; //주문코드

    @Column(name = "menu_code")
    private int menuCode; //메뉴코드

}
