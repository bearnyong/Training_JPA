package com.training01.table;

import javax.persistence.*;

/*
[ 제품 ]
- 제품 테이블의 접근은 필드 접근 타입이 아닌 속성 접근 타입으로 설정한다.
- 제품 번호는 데이터베이스에서 관리한다.
- 제품명은 중복되지 않는다.
- 제품 가격은 입력시 int로 사용자에게 입력을 받으나 저장시 000원으로 저장한다.
*/

@Entity(name = "training01_product") //엔티티 객체로 만들기 위한 어노테이션 (name: 엔티티를 식별하기 위한 네임)
@Table(name = "tbl_training01_product") //데이터베이스 엑세스 시 테이블 이름을 생성하기 위한 네임
@Access(AccessType.PROPERTY) //속성 접근 타입으로 설정 (getter에 @Id)
public class Product {

    private OrderPK orderPK;

    @Column(name = "pro_name", unique = true) //제품명은 중복되지 않는다.
    private String proName; //제품명

    @Column(name = "pro_price") //int로 입력 받지만 Stirng으로 저장된다...
    private String proPrice; //제품가격("__원" 형식)

    public Product() {
    }

    public Product(OrderPK orderPK, String proName, String proPrice) {
        this.orderPK = orderPK;
        this.proName = proName;
        this.proPrice = proPrice;
    }

    /*Getter*/
    @EmbeddedId //orderPK값 매핑...(속성 접근 타입)
    public OrderPK getOrderPK() {
        return orderPK;
    }

    public String getProName() {
        return proName;
    }

    public String getProPrice() {
        return proPrice;
    }

    /*Setter*/
    public void setOrderPK(OrderPK orderPK) {
        this.orderPK = orderPK;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public void setProPrice(String proPrice) {
        this.proPrice = proPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "orderPK=" + orderPK +
                ", proName='" + proName + '\'' +
                ", proPrice='" + proPrice + "원" + '\'' +
                '}';
    }
}
