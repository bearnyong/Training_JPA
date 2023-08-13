package com.training.nyongcafe.Order.controller;

import com.training.nyongcafe.Order.dto.OrderDTO;
import com.training.nyongcafe.Order.entity.Order;
import com.training.nyongcafe.Order.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders") //도메인
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping //01_전체조회(GET)
    public ResponseEntity<List<?>> readAllOrder() {
        List<Order> orderList = orderService.readAllOrder();
        if (orderList.size() <= 0) {
            return ResponseEntity.status(404).body(Collections.singletonList("error"));
        } else {
            List<OrderDTO> orderDTOList = orderList.stream().map(order -> new OrderDTO(order)).collect(Collectors.toList());
            return ResponseEntity.ok().body(orderDTOList);
        }
    }

    @GetMapping("/{orderCode}") //02_부분조회(GET)
    public ResponseEntity<?> readOneOrder(@PathVariable int orderCode) {
        Order order = orderService.readOneOrder(orderCode);
        if (Objects.isNull(order)) {
            return ResponseEntity.status(404).body("존재하지 않는 orderCode 입니다...");
        } else {
            OrderDTO orderDTO = new OrderDTO(order);
            return ResponseEntity.ok().body(orderDTO);
        }
    }


    @PostMapping //03_주문등록(POST)
    public ResponseEntity<?> insertOneOrder(OrderDTO orderDTO) {
        Order order = new Order(orderDTO);
        //dto에서 값을 넣으면 "2023-08-12T08:47:36.976+00:00" 또는 null
        order.setOrderDate(new Date());
        order.setOrederTime(new Date());

        int result = orderService.insertOneOrder(order);
        if (result == 0) {
            return ResponseEntity.status(404).body("주문 등록에 실패하였습니다...");
        } else {
            return ResponseEntity.ok().body("주문이 등록되었습니다.");
        }
    }

    @PutMapping //04_주문수정(PUT)
    public ResponseEntity<?> updateOneOrder(OrderDTO orderDTO) {
        Order findOrder = orderService.readOneOrder(orderDTO.getOrderCode());
        if (Objects.isNull(findOrder)) {
            return ResponseEntity.ok().body("해당 데이터가 존재하지 않습니다...");
        }
        
        OrderDTO order = orderDTO;
        order.getOrderCode();

        int result = orderService.updateOneOrder(findOrder, order);
        if (result == 0) {
            return ResponseEntity.status(404).body("주문 수정에 실패하였습니다...");
        } else {
            return ResponseEntity.ok().body(orderDTO.getOrderCode() + "번 주문이 수정되었습니다.");
        } 
    }
}
