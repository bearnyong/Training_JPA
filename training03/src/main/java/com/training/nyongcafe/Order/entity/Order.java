package com.training.nyongcafe.Order.entity;

import com.training.nyongcafe.Order.dto.OrderDTO;
import org.aspectj.weaver.ast.Or;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tbl_order")
public class Order { //1

    @Id
    @Column(name = "order_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //데이터베이스에서 관리하는 전략 사용
    private int orderCode; //주문코드(PK)

    @Column(name = "order_date")
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE) //날짜를 저장한다.
    private Date orderDate; //주문일자

    @Column(name = "order_time")
    @Temporal(TemporalType.TIME) //시간을 저장한다.
//    @DateTimeFormat(pattern = "HH:mm:ss")
    private Date orederTime; //주문시간

    @Column(name = "total_order_price")
    private int totalOrderPrice; //총주문금액

    @OneToMany(mappedBy = "order")
    private List<OrderMenu> orderMenuList = new ArrayList<OrderMenu>();

    public Order() {
    }

    public Order(OrderDTO orderDTO) {
        this.orderCode = orderDTO.getOrderCode();
        this.orderDate = orderDTO.getOrderDate();
        this.orederTime = orderDTO.getOrederTime();
        this.totalOrderPrice = orderDTO.getTotalOrderPrice();
    }

    public Order(int orderCode, Date orderDate, Date orederTime, int totalOrderPrice, List<OrderMenu> orderMenuList) {
        this.orderCode = orderCode;
        this.orderDate = orderDate;
        this.orederTime = orederTime;
        this.totalOrderPrice = totalOrderPrice;
        this.orderMenuList = orderMenuList;
    }

    public int getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(int orderCode) {
        this.orderCode = orderCode;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getOrederTime() {
        return orederTime;
    }

    public void setOrederTime(Date orederTime) {
        this.orederTime = orederTime;
    }

    public int getTotalOrderPrice() {
        return totalOrderPrice;
    }

    public void setTotalOrderPrice(int totalOrderPrice) {
        this.totalOrderPrice = totalOrderPrice;
    }

    public List<OrderMenu> getOrderMenuList() {
        return orderMenuList;
    }

    public void setOrderMenuList(List<OrderMenu> orderMenuList) {
        this.orderMenuList = orderMenuList;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderCode=" + orderCode +
                ", orderDate=" + orderDate +
                ", orederTime=" + orederTime +
                ", totalOrderPrice=" + totalOrderPrice +
                ", orderMenuList=" + orderMenuList +
                '}';
    }
}
