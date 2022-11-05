package com.lms.order.controller;

import com.lms.order.dto.OrderDTO;
import com.lms.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders/")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/")
    public OrderDTO createOrder(@RequestBody OrderDTO orderDTO) {
        return orderService.addOrder(orderDTO.getUserId(), orderDTO.getBookId());
    }

    @DeleteMapping("/{orderId}")
    public OrderDTO deleteOrder(@PathVariable Long orderId) {
        return new OrderDTO(orderService.deleteOrder(orderId));
    }

    @GetMapping("/{orderId}")
    public OrderDTO getOrderById(@PathVariable Long orderId) {
        return new OrderDTO(orderService.getOrderById(orderId));
    }

}
