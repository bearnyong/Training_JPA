package com.training.nyongcafe.Menu.repository;

import com.training.nyongcafe.Menu.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
