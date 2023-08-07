package com.training02.entity;

import javax.persistence.*;

@Entity(name = "training02_student")
@Table(name = "tbl_training02_student")
public class /*학생*/Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //데이터베이스에서 관리하는 전략 사용
    @Column(name = "stu_num", nullable = false) //NOT NULL
    private int stuNum; //학생번호(PK)
    @Column(name = "sut_name", nullable = false) //NOT NULL
    private String stuName; //학생명
    @Column(name = "stu_phone", nullable = false) //NOT NULL
    private String stuPhone; //전화번호
    @Column(name = "stu_addr", nullable = false) //NOT NULL
    private String stuAddr; //주소

    public Student() {
    }

    public Student(int stuNum, String stuName, String stuPhone, String stuAddr) {
        this.stuNum = stuNum;
        this.stuName = stuName;
        this.stuPhone = stuPhone;
        this.stuAddr = stuAddr;
    }

    /*빌더패턴 사용해보기*/
    public Student stuNum(int stuNum) {
        this.stuNum = stuNum;
        return this;
    }

    public Student stuName(String stuName) {
        this.stuName = stuName;
        return this;
    }

    public Student stuPhone(String stuPhone) {
        this.stuPhone = stuPhone;
        return this;
    }

    public Student stuAddr(String stuAddr) {
        this.stuAddr = stuAddr;
        return this;
    }

    public Student bulider() {
        return new Student(stuNum, stuName, stuPhone, stuAddr);
    }

    /*Getter, Setter*/

    public int getStuNum() {
        return stuNum;
    }

    public void setStuNum(int stuNum) {
        this.stuNum = stuNum;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuPhone() {
        return stuPhone;
    }

    public void setStuPhone(String stuPhone) {
        this.stuPhone = stuPhone;
    }

    public String getStuAddr() {
        return stuAddr;
    }

    public void setStuAddr(String stuAddr) {
        this.stuAddr = stuAddr;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuNum=" + stuNum +
                ", stuName='" + stuName + '\'' +
                ", stuPhone='" + stuPhone + '\'' +
                ", stuAddr='" + stuAddr + '\'' +
                '}';
    }
}
