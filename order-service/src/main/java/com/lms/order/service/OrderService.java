package com.lms.order.service;

import com.lms.order.dto.BookDTO;
import com.lms.order.dto.OrderDTO;
import com.lms.order.dto.UserDTO;
import com.lms.order.entity.Order;
import com.lms.order.exception.OrderNotFoundException;
import com.lms.order.repository.OrderRepository;
import com.lms.order.rest.BookServiceClient;
import com.lms.order.rest.UserServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public class OrderService {

    private final BookServiceClient bookServiceClient;
    private final UserServiceClient userServiceClient;
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(BookServiceClient bookServiceClient, UserServiceClient userServiceClient,
                        OrderRepository orderRepository) {
        this.bookServiceClient = bookServiceClient;
        this.userServiceClient = userServiceClient;
        this.orderRepository = orderRepository;
    }

    public OrderDTO addOrder(Long userId, Long bookId) {
        BookDTO bookById = bookServiceClient.getBookById(bookId);
        UserDTO userById = userServiceClient.getUserById(userId);
        orderRepository.save(new Order(userById.getUserId(), OffsetDateTime.now(), bookById.getBookId()));
        return new OrderDTO(userById.getUserId(), bookById.getBookId());
    }

    public Order deleteOrder(Long orderId) {
        Order deleteOrder = getOrderById(orderId);
        orderRepository.deleteById(orderId);
        return deleteOrder;
    }

    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId).orElseThrow(() -> new OrderNotFoundException
                ("Unable to find default order for order: " + orderId));
    }


}
