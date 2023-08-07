package com.training01;

import com.training01.enumType.RoleType;
import com.training01.table.Member;
import com.training01.table.Order;
import com.training01.table.OrderPK;
import org.junit.jupiter.api.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

public class Training01Tests {

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
    public void Member_table_왜_생성_안되니() {
        Member member = new Member();
        member.setMemName("이상우");
        member.setMemNickname("릴라릴라고릴라");
        member.setMemPhone("010-1234-5678");
        member.setMemPostcode("10110");
        member.setMemGeneralAddr("경기도 김포시");
        member.setMemDetailedAddr("하이미디어");
        member.setMemRole(RoleType.MEMBER);
        member.setMemStatus("Y");
        member.setMemInsertDate(new Date());

        entityManager.persist(member);
    }

    @Test
    public void 이게_되는건가() {
        /*EmbeddedId 확인해보기?*/
        Order order = new Order();
        order.setOrderPK(new OrderPK());
        order.setOrderStatus("Y");
        order.setOrderDate(new Date());

        entityManager.persist(order);

        EntityTransaction transaction = entityManager.getTransaction();
//        transaction.commit();
    }
}
