package com.training.nyongcafe.Menu.controller;

import com.training.nyongcafe.Menu.dto.MenuDTO;
import com.training.nyongcafe.Menu.entity.Menu;
import com.training.nyongcafe.Menu.service.MenuService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        List<Menu> menuList = menuService.readAllMenus();
        if (menuList.size() <= 0) {
            return ResponseEntity.status(404).body(Collections.singletonList("error"));
        } else {
            List<MenuDTO> menuDTOList = menuList.stream().map(menu -> new MenuDTO(menu)).collect(Collectors.toList()); //객체의 getter로 List 만든다.
            System.out.println("----------- 전제 조회 완료");
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
}
