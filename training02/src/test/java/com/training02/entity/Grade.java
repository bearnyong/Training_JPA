package com.training02.entity;

import javax.persistence.*;


/* 양방향은 외래 키가 있는 쪽이 연관관계의 주인이다.
 * 일대다와 다대일 연관관계는 항상 다(N)에 외래 키가 있다.
 * 여기서는 다(N)쪽인 Grade 테이블이 외래 키를 가지고 있으므로 Grade.student가 연관관계의 주인이 된다?
 * Student.grades는 조회를 위한 JPQL이나 객체 그래프를 탐색할 때 사용한다? */

@Entity(name = "training02_grade")
@Table(name = "tbl_training02_grade")
public class /*학점*/Grade {

    @EmbeddedId //gradePK값 매핑
    private GradePK gradePK;

    @Column(name = "semester", nullable = false) //NOT NULL
    private String semester; //학기 "0학기"의 형식

    @Column(name = "grade_score", nullable = false) //NOT NULL
    private int gradeScore; //과목점수

    @ManyToOne
    @JoinColumn(name = "stu_num")
    private Student student;

    public Grade() {
    }

    public Grade(GradePK gradePK, String semester, int gradeScore, Student student) {
        this.gradePK = gradePK;
        this.semester = semester;
        this.gradeScore = gradeScore;
        this.student = student;
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
        return new Grade(gradePK, semester, gradeScore, student);
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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "gradePK=" + gradePK +
                ", semester='" + semester + '\'' +
                ", gradeScore=" + gradeScore +
                ", student=" + student +
                '}';
    }
}
