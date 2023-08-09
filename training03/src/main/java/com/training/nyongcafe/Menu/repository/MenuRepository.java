package com.training.nyongcafe.Menu.repository;

import com.training.nyongcafe.Menu.dto.MenuDTO;
import com.training.nyongcafe.Menu.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Integer> {
    Menu findById/*service에서 불러온 애 이름 맞추기*/(int menuCode); //02_부분조회(GET)- DTO

}
