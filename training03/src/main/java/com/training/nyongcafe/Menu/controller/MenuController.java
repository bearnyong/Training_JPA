package com.training.nyongcafe.Menu.controller;

import com.training.nyongcafe.Menu.dto.MenuDTO;
import com.training.nyongcafe.Menu.entity.Category;
import com.training.nyongcafe.Menu.entity.Menu;
import com.training.nyongcafe.Menu.service.MenuService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/menus") //도메인
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        /* bean에서 등록될 수 있도록 설정 */
        this.menuService = menuService;
    }

    /* RestAPI 기반 작성법
     * GET(조회): /menus/1 -> 메뉴들 중 한가지를 확인하고자 할 때
     * GET(조회): /menus? -> 메뉴 전체를 대상으로 무언가를 하고 싶을 때(ex.주문 목록 확인할 때 /menus?order)
     * POST(등록): /menus
     * PUT(수정): /menus/1?
     * DELETE(삭제): /menus/1 -> /menus일 경우, 전체를 삭제한다는 의미이기 떄문에 말이 안됨...
     * */

    @GetMapping("/read/list") //01_전체조회(GET)- DTO
    public ResponseEntity<List<?>> readAllMenus() { //localhost:8000/menus/read/list
        System.out.println("----------- 전체 메뉴 조회 시작");
        List<Menu> menuList = menuService.readAllMenus();
        if (menuList.size() <= 0) {
            return ResponseEntity.status(404).body(Collections.singletonList("error"));
        } else {
            List<MenuDTO> menuDTOList = menuList.stream().map(menu -> new MenuDTO(menu)).collect(Collectors.toList()); //객체의 getter로 List 만든다.
            System.out.println("----------- 전제 메뉴 조회 완료");
            return ResponseEntity.ok().body(menuDTOList);
        }
    }

    @GetMapping("/read/{menuCode}") //02_부분조회(GET)- DTO
    public ResponseEntity<?> readOneMenu(@PathVariable int menuCode) { //localhost:8000/menus/read/1
        System.out.println("----------- " + menuCode + "번 메뉴 조회 시작");
        Menu menu = menuService.readOneMenu(menuCode);
        if (Objects.isNull(menu)) {
            return ResponseEntity.status(404).body("존재하지 않는 menuCode 입니다...");
        } else {
            MenuDTO menuDTO = new MenuDTO(menu);
            System.out.println("----------- " + menuDTO.getMenuCode() + "번 메뉴 조회 완료");
            return ResponseEntity.ok().body(menuDTO);
        }
    }

    @PostMapping("/insert") //03_메뉴등록(POST)- DTO
    public ResponseEntity<?> insertOneMenu(MenuDTO menuDTO) {
        System.out.println("----------- 메뉴 등록 시작");
        Menu menu = new Menu(menuDTO); //메뉴코드(자동), 메뉴명, 메뉴가격, 주문가능상태
        menu.setCategory(new Category().categoryCode(menuDTO.getCategoryCode())); //카테고리코드
//        menu.setCategory(new Category().categoryCode(1)); //1값... 일단 넣어주기...

        int result = menuService.insertOneMenu(menu);
        if (result == 0) {
            return ResponseEntity.status(404).body("메뉴 등록에 실패하였습니다...");
        } else if (result == 1) {
            System.out.println(menu);
            System.out.println("----------- 메뉴 등록 완료: " + menu.getMenuName());
            return ResponseEntity.ok().body("메뉴: " + menu.getMenuName() + " (이)가 등록되었습니다.");
        } else {
            return ResponseEntity.status(500).body("알 수 없는 오류가 발생하였습니다...");
        }
    }

    @PutMapping("/update") //04_메뉴수정(PUT)- DTO
    public ResponseEntity<?> updateOneMenu(MenuDTO menuDTO) {
        System.out.println("----------- 메뉴 수정 시작");

        /* update를 위해 바꾸고자 하는 값이 영속 상태(존재 상태)인지 확인한다.
         * 만약 영속성 컨텍스트에 없을 경우, 영속화를 진행후 .save() 호출시 DB에 반영 되기에 if문 실행 */
        Menu findMenu = menuService.readOneMenu(menuDTO.getMenuCode());
        if (Objects.isNull(findMenu)) {
            /* 조회 성공: 엔티티가 존재함
             * 조회 실패: 업데이트 대상이 존재하지 않음 */
            return ResponseEntity.ok().body("해당 데이터가 존재하지 않습니다...");
        }

        /* update 과정
         * 1)변경전[0,0,0] -> 2)변경후[0,0,1] -> 3)save(id) 메서드 호출 후 변경 전,후 값 비교
         * -> 4)영속성컨텍스트[0,0,1]저장 -> 5)DB에 반영 */
        MenuDTO menu = menuDTO; //메뉴명, 메뉴가격, 주문가능상태
        menu.getCategoryCode(); //카테고리코드

        int result = menuService.updateOneMenu(findMenu, menu);
        if (result == 0) {
            return ResponseEntity.status(404).body("메뉴 수정에 실패하였습니다...");
        } else if (result == 1) {
            System.out.println(menu);
            System.out.println("----------- " + menu.getMenuCode() + "번 메뉴 수정 완료");
            return ResponseEntity.ok().body(menu.getMenuCode() + "번 메뉴가 수정되었습니다.");
        } else {
            return ResponseEntity.status(500).body("알 수 없는 오류가 발생하였습니다...");
        }
    }
}
