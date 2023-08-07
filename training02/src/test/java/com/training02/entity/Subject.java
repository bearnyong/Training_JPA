package com.training02.entity;

import javax.persistence.*;

@Entity(name = "training02_subject")
@Table(name = "tbl_training02_subject")
public class /*과목*/Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //데이터베이스에서 관리하는 전략 사용
    @Column(name = "sub_num", nullable = false) //NOT NULL
    private int subNum; //과목번호(PK)
    @Column(name = "sub_name", nullable = false) //NOT NULL
    private String subName; //과목명

    public Subject() {
    }

    public Subject(int subNum, String subName) {
        this.subNum = subNum;
        this.subName = subName;
    }

    /*빌더패턴 사용해보기*/
    public Subject subNum(int subNum) {
        this.subNum = subNum;
        return this;
    }

    public Subject subName(String subName) {
        this.subName = subName;
        return this;
    }

    public Subject bulider() {
        return new Subject(subNum, subName);
    }

    /*Getter, Setter*/
    public int getSubNum() {
        return subNum;
    }

    public void setSubNum(int subNum) {
        this.subNum = subNum;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subNum=" + subNum +
                ", subName='" + subName + '\'' +
                '}';
    }
}
