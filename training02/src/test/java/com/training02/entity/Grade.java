package com.training02.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "training02_grade")
@Table(name = "tbl_training02_grade")
public class /*학점*/Grade {

    @EmbeddedId //gradePK값 매핑
    private GradePK gradePK;

    @Column(name = "semester", nullable = false) //NOT NULL
    private String semester; //학기 "0학기"의 형식

    @Column(name = "grade_score", nullable = false) //NOT NULL
    private int gradeScore; //과목점수

    public Grade() {
    }

    public Grade(GradePK gradePK, String semester, int gradeScore) {
        this.gradePK = gradePK;
        this.semester = semester;
        this.gradeScore = gradeScore;
    }

    /*빌더패턴 사용해보기*/
    public Grade semester(String semester) {
        this.semester = semester;
        return this;
    }

    public Grade gradeScore(int gradeScore) {
        this.gradeScore = gradeScore;
        return this;
    }

    public Grade builder() {
        return new Grade(gradePK, semester, gradeScore);
    }

    /*Getter, Setter*/
    public GradePK getGradePK() {
        return gradePK;
    }

    public void setGradePK(GradePK gradePK) {
        this.gradePK = gradePK;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public int getGradeScore() {
        return gradeScore;
    }

    public void setGradeScore(int gradeScore) {
        this.gradeScore = gradeScore;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "gradePK=" + gradePK +
                ", semester='" + semester + '\'' +
                ", gradeScore=" + gradeScore +
                '}';
    }
}
