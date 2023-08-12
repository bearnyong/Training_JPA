package com.training.nyongcafe.Order.dto;

import com.training.nyongcafe.Order.entity.Order;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderDTO {

    private int orderCode; //주문코드(PK)
    private Date orderDate; //주문일자
    private Date orederTime; //주문시간
    private int totalOrderPrice; //총주문금액

    public OrderDTO() {
    }

    public OrderDTO(Order order) {
        this.orderCode = order.getOrderCode();
        this.orderDate = order.getOrderDate();
        this.orederTime = order.getOrederTime();
        this.totalOrderPrice = order.getTotalOrderPrice();
    }

    public OrderDTO(int orderCode, Date orderDate, Date orederTime, int totalOrderPrice) {
        this.orderCode = orderCode;
        this.orderDate = orderDate;
        this.orederTime = orederTime;
        this.totalOrderPrice = totalOrderPrice;
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

    @Override
    public String toString() {
        return "OrderDTO{" +
                "orderCode=" + orderCode +
                ", orderDate=" + orderDate +
                ", orederTime=" + orederTime +
                ", totalOrderPrice=" + totalOrderPrice +
                '}';
    }
}
