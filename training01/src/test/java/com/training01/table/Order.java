package com.training01.table;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/*
[ 주문 ]
- 주문번호는 데이터 베이스에서 관리한다.
- 참조되는 회원번호는 무시한다. (삭제함)
- 주문일, 수정일, 삭제일은 날짜 타입으로 원하는 설정으로 저장한다.
*/

@Entity(name = "training01_order") //엔티티 객체로 만들기 위한 어노테이션 (name: 엔티티를 식별하기 위한 네임)
@Table(name = "tbl_training01_order") //데이터베이스 엑세스 시 테이블 이름을 생성하기 위한 네임
public class Order {

    @EmbeddedId //orderPK값 매핑...(필드 접근 타입)
    private OrderPK orderPK;

    @Column(name = "order_num")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //데이터베이스에서 관리하는 전략 사용
    private int orderNum; //주문번호

    @Column(name = "order_status")
    private String orderStatus; //주문상태

    @Column(name = "order_date")
    @Temporal(TemporalType.DATE) //날짜를 저장한다.
    private Date orderDate; //주문일

    @Column(name = "order_update_date")
    @Temporal(TemporalType.DATE) //날짜를 저장한다.
    private Date orderUpdateDate; //주문수정일

    @Column(name = "order_delete_date")
    @Temporal(TemporalType.DATE) //날짜를 저장한다.
    private Date orderDeleteDate; //주문삭제일

//    @JoinColumn(name = "mem_num")
//    @ManyToOne
    @Column(name = "mem_num")
    private int memberNum;
    //주문번호 1개 -> 회원 한 명

    public Order() {
    }

    public Order(OrderPK orderPK, String orderStatus, Date orderDate, Date orderUpdateDate, Date orderDeleteDate) {
        this.orderPK = orderPK;
        this.orderStatus = orderStatus;
        this.orderDate = orderDate;
        this.orderUpdateDate = orderUpdateDate;
        this.orderDeleteDate = orderDeleteDate;
    }

    public OrderPK getOrderPK() {
        return orderPK;
    }

    public void setOrderPK(OrderPK orderPK) {
        this.orderPK = orderPK;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getOrderUpdateDate() {
        return orderUpdateDate;
    }

    public void setOrderUpdateDate(Date orderUpdateDate) {
        this.orderUpdateDate = orderUpdateDate;
    }

    public Date getOrderDeleteDate() {
        return orderDeleteDate;
    }

    public void setOrderDeleteDate(Date orderDeleteDate) {
        this.orderDeleteDate = orderDeleteDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderPK=" + orderPK +
                ", orderStatus='" + orderStatus + '\'' +
                ", orderDate=" + orderDate +
                ", orderUpdateDate=" + orderUpdateDate +
                ", orderDeleteDate=" + orderDeleteDate +
                '}';
    }
}
