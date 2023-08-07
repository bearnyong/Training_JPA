package com.training02.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class GradePK implements Serializable {

    @Column(name = "stu_num")
    private int stuNum; //학생번호(PK)

    @Column(name = "sub_num")
    private int subNum; //과목번호(PK)

    public GradePK() {
    }

    public GradePK(int stuNum, int subNum) {
        this.stuNum = stuNum;
        this.subNum = subNum;
    }

    public int getStuNum() {
        return stuNum;
    }

    public void setStuNum(int stuNum) {
        this.stuNum = stuNum;
    }

    public int getSubNum() {
        return subNum;
    }

    public void setSubNum(int subNum) {
        this.subNum = subNum;
    }

    @Override
    public String toString() {
        return "GradePK{" +
                "stuNum=" + stuNum +
                ", subNum=" + subNum +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GradePK gradePK = (GradePK) o;
        return stuNum == gradePK.stuNum && subNum == gradePK.subNum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(stuNum, subNum);
    }
}
