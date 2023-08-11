package com.training.nyongcafe.Order.dto;

public class OrderDTO {

    private int orderCode; //주문코드(PK)
    private String orderDate; //주문일자
    private String orederTime; //주문시간
    private int totalOrderPrice; //총주문금액

    public OrderDTO() {
    }

    public OrderDTO(int orderCode, String orderDate, String orederTime, int totalOrderPrice) {
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

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrederTime() {
        return orederTime;
    }

    public void setOrederTime(String orederTime) {
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
                ", orderDate='" + orderDate + '\'' +
                ", orederTime='" + orederTime + '\'' +
                ", totalOrderPrice=" + totalOrderPrice +
                '}';
    }
}
