package com.training.nyongcafe.Order.repository;

import com.training.nyongcafe.Menu.entity.Menu;
import com.training.nyongcafe.Order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
