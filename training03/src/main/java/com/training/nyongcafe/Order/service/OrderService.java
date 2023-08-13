package com.training.nyongcafe.Order.service;

import com.training.nyongcafe.Order.dto.OrderDTO;
import com.training.nyongcafe.Order.entity.Order;
import com.training.nyongcafe.Order.repository.OrderRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    @Transactional
    public int updateOneOrder(Order findOrder, OrderDTO order) { //04_주문수정(PUT)
//        if (!Objects.isNull(order.getOrderDate())) {
//            findOrder.setOrderDate(order.getOrderDate());
//        }
//        if (!Objects.isNull(order.getOrederTime())) {
//            findOrder.setOrederTime(order.getOrederTime());
//        }
        if (order.getTotalOrderPrice() > 0) {
            findOrder.setTotalOrderPrice(order.getTotalOrderPrice());
        }

        Order result = orderRepository.save(findOrder);
        if (Objects.isNull(result)) {
            return 0;
        } else {
            return 1;
        }
    }


    public void deleteOneOrder(int deleleteOrderCode) { //05_주문삭제(DELETE)
        orderRepository.deleteById(deleleteOrderCode);
        Order order = orderRepository.findById(deleleteOrderCode);
    }
}
