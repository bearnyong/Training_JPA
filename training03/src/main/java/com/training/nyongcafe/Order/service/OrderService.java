package com.training.nyongcafe.Order.service;

import com.training.nyongcafe.Order.entity.Order;
import com.training.nyongcafe.Order.repository.OrderRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> readAllOrder() { //01_전체조회(GET)
        List<Order> orderList = orderRepository.findAll();

        return orderList;
    }

    public Order readOneOrder(int orderCode) { //02_부분조회(GET)
        Order order = orderRepository.findById(orderCode);
        return order;
    }

    @Transactional
    public int insertOneOrder(Order order) { //03_주문등록(POST)
        Order result = orderRepository.save(order);
        if (Objects.isNull(result)) {
            return 0;
        } else {
            return 1;
        }
    }

}
