package com.training02.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "Student") //반대편 필드에 적힌 이름...
    //연관관계의 주인 정하기... 양뱡향 관계에서 주체가 되는 쪽(Many쪽, 외래키가 있는 쪽)을 정의
    private List<Grade> grades = new ArrayList<Grade>();

    public Student() {
    }


    public Student(int stuNum, String stuName, String stuPhone, String stuAddr, List<Grade> grades) {
        this.stuNum = stuNum;
        this.stuName = stuName;
        this.stuPhone = stuPhone;
        this.stuAddr = stuAddr;
        this.grades = grades;
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
        return new Student(stuNum, stuName, stuPhone, stuAddr, grades);
    }

    /*Getter, Setter*/
//    public void addGrade(Grade grade) {
//        this.grades.add(grade);
//        if (grade.getStudent() != this) { //무한루프에 빠지지 않도록 체크...
//            grade.setStudent(this);
//        }
//    }


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

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuNum=" + stuNum +
                ", stuName='" + stuName + '\'' +
                ", stuPhone='" + stuPhone + '\'' +
                ", stuAddr='" + stuAddr + '\'' +
                ", grades=" + grades +
                '}';
    }
}
