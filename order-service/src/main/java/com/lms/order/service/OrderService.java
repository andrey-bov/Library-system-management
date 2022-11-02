package com.lms.order.service;

import com.lms.order.controller.dto.OrderDTO;
import com.lms.order.entity.Order;
import com.lms.order.repository.OrderRepository;
import com.lms.order.rest.BookDTO;
import com.lms.order.rest.BookServiceClient;
import com.lms.order.rest.UserDTO;
import com.lms.order.rest.UserServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.Optional;

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

    public Optional<?> deleteOrder(Long orderId) {
        Optional<Order> deleteOrder = orderRepository.findById(orderId);
        orderRepository.deleteById(orderId);
        return deleteOrder;
    }

}
