package com.training01.table;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;
import java.util.Objects;

@Embeddable //복합키를 지정할 때 사용한다.
public class OrderPK implements Serializable {

    @Column(name = "order_num")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //데이터베이스에서 관리하는 전략 사용
    private int orderNum; //주문번호

    @Column(name = "pro_num")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //데이터베이스에서 관리하는 전략 사용
    private int proNum; //제품번호

    public OrderPK() {
    }

    public OrderPK(int orderNum, int proNum) {
        this.orderNum = orderNum;
        this.proNum = proNum;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public int getProNum() {
        return proNum;
    }

    public void setProNum(int proNum) {
        this.proNum = proNum;
    }

    @Override
    public String toString() {
        return "OrderPK{" +
                "orderNum=" + orderNum +
                ", proNum=" + proNum +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderPK orderPK = (OrderPK) o;
        return orderNum == orderPK.orderNum && proNum == orderPK.proNum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNum, proNum);
    }
}
