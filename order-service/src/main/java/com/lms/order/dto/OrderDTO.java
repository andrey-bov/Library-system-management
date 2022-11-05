package com.lms.order.dto;

import com.lms.order.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    private Long orderId;

    private Long userId;

    private Long bookId;

    public OrderDTO(Order order) {
        orderId = order.getOrderId();
        userId = order.getUserId();
        bookId = order.getBookId();
    }

    public OrderDTO(Long userId, Long bookId) {
        this.userId = userId;
        this.bookId = bookId;
    }
}
