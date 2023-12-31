package com.training02;

import com.training02.entity.Grade;
import com.training02.entity.GradePK;
import com.training02.entity.Student;
import com.training02.entity.Subject;
import org.junit.jupiter.api.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class Training02Tests {

    private static EntityManagerFactory entityManagerFactory; //Entity를 만들기 위한 공장
    private EntityManager entityManager;

    @BeforeAll //최초 1회 실행
    public static void initFactory() {
        entityManagerFactory = Persistence.createEntityManagerFactory(/*환경등록*/"jpatest");
    }

    @BeforeEach //테스트 케이스별 실행 전마다 실행
    public void initManager() {
        //테스트 전에 null 값을 가지고 있는 entityManager에 생성하여 넣어준다.
        entityManager = entityManagerFactory.createEntityManager();
    }

    @AfterEach //테스트 케이스별 실행 후마다 실행
    public void closeManager() {
        entityManager.close();
    }

    @AfterAll //모든 테스트 종료후 1회 실행 (공장 닫아주기~ 종료 됐어요~)
    public static void closeFactory() {
        entityManagerFactory.close();
    }

    @Test
    public void test1() {
        Student student = new Student();
        student.stuName("민지");
        student.stuPhone("010-2345-3456");
        student.stuAddr("강남");

        entityManager.persist(student);
    }

    @Test
    public void test2() {
        Subject subject = new Subject().subName("edldld").bulider();

        System.out.println(subject);
    }

    @Test
    public void student_subject_셋_다_들어가나요_1() {
        /*Student*/
        //num은 DB에서 관리 @GeneratedValue
        Student student = new Student().stuName("고민영").stuAddr("김포").stuPhone("010-3423-23414").bulider();
        entityManager.persist(student);
        System.out.println(student);

        /*Subject*/
        Subject subject = new Subject().subName("edldld").bulider();
        entityManager.persist(subject);
        System.out.println(subject);

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        transaction.commit();

        /*Grade*/
        //GradePK에 값을 그냥 넣어줌...
        Student student1 = entityManager.find(Student.class, 1);
        Subject subject1 = entityManager.find(Subject.class, 1);

        //값이 들어갔는지 확인
        System.out.println(student1);
        System.out.println(subject1);

        Grade grade = new Grade();
        grade.setGradePK(new GradePK(student.getStuNum(), subject.getSubNum())); //GradePK
        grade.setSemester("1학기");
        grade.setGradeScore(100);
        entityManager.persist(grade);

        transaction.begin();
        transaction.commit();
    }

    @Test
    public void student_subject_셋_다_들어가나요_2_코드_줄이기() {
        /*Student*/
        Student student = new Student().stuName("고민영").stuAddr("김포").stuPhone("010-3423-23414").bulider();
        entityManager.persist(student);
        System.out.println(student);

        /*Subject*/
        Subject subject = new Subject().subName("edldld").bulider();
        entityManager.persist(subject);
        System.out.println(subject);

        EntityTransaction transaction = entityManager.getTransaction();

        /*Grade*/
        //GradePK에 값을 그냥 넣어줌...
        Grade grade = new Grade();
        grade.setGradePK(new GradePK(student.getStuNum(), subject.getSubNum())); //GradePK
        grade.setSemester("1학기");
        grade.setGradeScore(100);
        entityManager.persist(grade);

        transaction.begin();
        transaction.commit();
    }

    /* 양방향 연관관계의 주의점
     * 가장 흔히 하는 실수: 연관관계의 주인에는 값을 입력하지 않고, 주인이 아닌 곳에만 값을 입력하는 것
     * 데이터베이스에 외래 키 값이 정상적으로 저장되지 않을 경우, 가장 먼저 의심해보기!
     *
     * 객체 관점에서 양쪽 방향 모두 값을 입력해주는 것이 가장 안전하다.*/

    @Test
    public void 양방향_연관관계_저장() {
        //...185페이지...
        //student 저장
        Student student = new Student().stuName("이상우").stuAddr("김포다").stuPhone("010-1234-5678").bulider();
        entityManager.persist(student);

        //grade1 저장
        Grade grade1 = new Grade().semester("1학기").gradeScore(80).builder();
        grade1.setGradePK(new GradePK(student.getStuNum(),1));
        grade1.setStudent(student); //연관관계 설정 grade1 -> student
        System.out.println(grade1);
        entityManager.persist(grade1);

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        transaction.commit();

        //grade2 저장
        Grade grade2 = new Grade().semester("3학기").gradeScore(50).builder();
        grade2.setGradePK(new GradePK(student.getStuNum(),1));
        grade2.setStudent(student); //연관관계 설정 grade2 -> student
        System.out.println(grade2);
        entityManager.persist(grade2);

        transaction.begin();
        transaction.commit();

    }

    @Test
    public void 양방향_모두_관계를_설정() {
        EntityTransaction transaction = entityManager.getTransaction();

        //...188페이지...
        Student student1 = new Student().stuName("이상우").stuAddr("김포다").stuPhone("010-1234-5678").bulider();
        Subject subject1 = new Subject();
        subject1.setSubName("국어");
        entityManager.persist(subject1);

        Grade grade1 = new Grade();
        grade1.setGradePK(new GradePK(student1.getStuNum(), subject1.getSubNum())); //학점->학생 관계설정 (연관관계의 주인, 외래키를 관리한다.)
        grade1.setGradeScore(80);
        grade1.setSemester("1학기");

        List<Grade> gredeList = new ArrayList<>();
        gredeList.add(grade1);
        student1.setGrades(gredeList);

        entityManager.persist(student1);
        transaction.begin();
        transaction.commit();
    }

    @Test
    public void 다대일_Grade_대_Student_객체_삽입_테스트() {
        Student student = new Student().stuName("이상우").stuAddr("하이미디어").stuPhone("010-1234-23414").bulider();
        Subject subject = new Subject().subName("국어").bulider();
        Grade grade = new Grade().semester("2학기").gradeScore(30).builder();

        System.out.println(student);
        System.out.println(subject);
        System.out.println(grade);

//        grade.setStudent(student);
//        grade.setSubject(subject);

        System.out.println(grade);

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

//        entityManager.persist(student);
//        entityManager.persist(subject);
        entityManager.persist(grade);

        transaction.commit();
    }

    @Test
    public void 일대다_방향으로_객체_그래프_탐색() {
        //...181페이지...
        Student st = entityManager.find(Student.class, 1);
        List<Grade> gr = st.getGrades();

        for (Grade grade : gr) {
            System.out.println(grade.getSemester() + ", " + grade.getGradeScore());
        }

    }

    @Test
    public void 양방향_연관관계_주인_객체를_이용한_삽입_테스트() {
        Student student = new Student().stuName("고민영").stuAddr("김포").stuPhone("010-3423-23414").bulider();
        entityManager.persist(student);
        System.out.println(student);

        Grade grade = new Grade().semester("2학기").gradeScore(30).builder();
        grade.setStudent(entityManager.find(Student.class, 1));

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(grade);
        transaction.commit();
    }
}
