package com.training.nyongcafe.Menu.service;

import com.training.nyongcafe.Menu.dto.MenuDTO;
import com.training.nyongcafe.Menu.entity.Category;
import com.training.nyongcafe.Menu.entity.Menu;
import com.training.nyongcafe.Menu.repository.MenuRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service //<context:component-scan>에 의해 스프링 빈으로 등록된다.
public class MenuService {

    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    /* JpaRepository 공통 인터페이스 기능
     * JpaRepository 인터페이스를 상속받으면 사용할 수 있는 주요 메소드
     * --> T는 엔티티, ID는 엔티티의 식별자 타입, S는 엔티티와 그 자식 타입
     * findAll(): 모든 엔티티를 조회한다. 정렬(sort)이나 페이징(pageable)조건을 파라미터로 제공할 수 있다.
     * findById(): Id 값으로 데이터 조회
     * findOne(ID): 엔티티 하나를 조회한다. 내부에서 EntityManager.find()를 호출한다.
     * save(S): 새로운 엔티티는 저장하고 이미 있는 엔티티는 수정한다. --엔티티에 식별자 값이 없으면(null) 새로운 엔티티로 판단해서 EntityManager.merge()를 호출한다.
     * delete(T): 엔티티 하나를 삭제한다. 내부에서 EntityManager.remove()를 호출한다.
     * getOne(ID): 엔티티를 프록시로 조회한다. 내부에서 EntitiyManager.getReference()를 호출한다. */

    public List<Menu> readAllMenus() { //01_전체조회(GET)
        List<Menu> menuList = menuRepository.findAll(); //MenuRepository에 따로 추가하지 않아도 이 친구가 알아서 해줌

        return menuList;
    }

    public Menu readOneMenu(int menuCode) { //02_부분조회(GET)
        Menu menu = menuRepository.findById(menuCode); //menuRepository에 findById 이름 그대로 가져가기
        return menu;
    }

    /* @Transactional
     * 스프링 프레임워크는 이 어노테이션이 붙어 있는 클래스나 메소드에 트랜잭션을 적용한다.
     * 외부에서 이클래스의 메소드를 호출할 떄 트랜잭션을 시작하고 메소드를 종료할 때 트랜잭션을 커밋한다.
     * 만약 예외가 발생하면 트랜잭션을 롤백한다.(503페이지) */
    @Transactional
    public int insertOneMenu(Menu menu) { //03_메뉴등록(POST)
        Menu result = menuRepository.save(menu);
        if (Objects.isNull(result)) {
            return 0; //result가 null일 경우 0 반환
        } else {
            return 1; //result가 null이 아닐 경우 1 반환
        }
    }

    @Transactional
    public int updateOneMenu(Menu findMenu, MenuDTO menu) { //04_메뉴수정(PUT)
        if (!Objects.isNull(menu.getMenuName())) { //메뉴명
            //넘어온 값이 null이 아닐 경우
            findMenu.setMenuName(menu.getMenuName());
        }
        if (menu.getMenuPrice() > 0) { //메뉴가격
            //넘어온 값이 0보다 클 경우 (기본값 0)
            findMenu.setMenuPrice(menu.getMenuPrice());
        }
        if (!Objects.isNull(menu.getOrderableStatus())) { //주문가능상태
            //넘어온 값이 null이 아닐 경우
            findMenu.setOrderableStatus(menu.getOrderableStatus());
        }
        if (menu.getCategoryCode() > 0) { //카테고리코드
            //넘어온 값이 0보다 클 경우 (기본값 0)
            findMenu.setCategory(new Category().categoryCode(menu.getCategoryCode()));
        }

        Menu result = menuRepository.save(findMenu);
        if (Objects.isNull(result)) {
            return 0;
        } else {
            return 1;
        }
    }

    @Transactional
    public void deleteOneMenu(int deleteMenuCode) { //05_메뉴삭제(DELETE)
        menuRepository.deleteById(deleteMenuCode);
        Menu menu = menuRepository.findById(deleteMenuCode);
    }
}
