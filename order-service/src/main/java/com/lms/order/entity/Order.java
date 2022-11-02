package com.lms.order.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "order_table")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long orderId;

    private Long userId;

    private Long bookId;

    private OffsetDateTime createData;


    public Order(Long userId, OffsetDateTime createData, Long bookId) {
        this.createData = createData;
        this.bookId = bookId;
        this.userId = userId;
    }

}
