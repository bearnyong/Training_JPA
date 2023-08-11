package com.training.nyongcafe.Order.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tbl_order")
public class Order { //1

    @Id
    @Column(name = "order_code")
    private int orderCode; //주문코드(PK)

    @Column(name = "order_date")
    @Temporal(TemporalType.DATE) //날짜를 저장한다.
    private Date orderDate; //주문일자

    @Column(name = "order_time")
    @Temporal(TemporalType.TIME) //시간을 저장한다.
    private Date orederTime; //주문시간

    @Column(name = "total_order_price")
    private int totalOrderPrice; //총주문금액


}
