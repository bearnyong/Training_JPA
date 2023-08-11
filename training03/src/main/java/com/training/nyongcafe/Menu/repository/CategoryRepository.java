package com.training.nyongcafe.Menu.repository;

import com.training.nyongcafe.Menu.entity.Category;
import com.training.nyongcafe.Menu.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findById(int categoryCode); //02_부분조회(GET)
}
