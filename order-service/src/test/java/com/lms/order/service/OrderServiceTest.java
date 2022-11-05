package com.lms.order.service;

import com.lms.order.dto.BookDTO;
import com.lms.order.dto.OrderDTO;
import com.lms.order.dto.UserDTO;
import com.lms.order.rest.BookServiceClient;
import com.lms.order.rest.UserServiceClient;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.OffsetDateTime;

@RunWith(MockitoJUnitRunner.class)
class OrderServiceTest {

    @InjectMocks
    private OrderService orderService;
    @Mock
    private BookServiceClient bookServiceClient;
    @Mock
    private UserServiceClient userServiceClient;

    @Test
    public void orderServiceTest_exception() {
        orderService.addOrder(null, null);
    }

    @Test
    public void orderServiceTest() {
        Mockito.when(bookServiceClient.getBookById(ArgumentMatchers.anyLong())).thenReturn(createBookDTO());
        Mockito.when(userServiceClient.getUserById(ArgumentMatchers.anyLong())).thenReturn(createUserDTO());
        OrderDTO order = orderService.addOrder(1L, 1L);
        Assertions.assertThat(order.getBookId()).isEqualTo(1L);
    }

    private UserDTO createUserDTO() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(1L);
        userDTO.setPhone("123");
        userDTO.setName("name");
        userDTO.setEmail("ewq@mail");
        userDTO.setCreationData(OffsetDateTime.now());
        return userDTO;
    }

    private BookDTO createBookDTO() {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setBookId(1L);
        bookDTO.setTitle("title");
        bookDTO.setAuthor("author");
        bookDTO.setData(1);
        bookDTO.setAddDataTime(OffsetDateTime.now());
        return bookDTO;
    }

}