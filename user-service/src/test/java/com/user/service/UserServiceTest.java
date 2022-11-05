package com.user.service;

import com.user.entity.User;
import com.user.repository.UserRepository;
import junit.framework.TestCase;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;

import java.time.OffsetDateTime;
@DirtiesContext
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest extends TestCase {

    @Mock
    private UserRepository userRepository;

    @Test
    public void testCreateUser() {
        User user = new User("name" , "email" , "123", OffsetDateTime.now());
        Assertions.assertThat(userRepository.save(user));
    }

}