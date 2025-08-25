package com.sinse.restaurant.controller;

import com.sinse.restaurant.domain.User;
import com.sinse.restaurant.model.user.UserService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RequiredArgsConstructor
class UserServiceTest {

    private final UserService userService;

    @Test
    void testCreateAndFindUser() {
        User user = userService.createUser("홍길동", "hong@test.com");
        assertNotNull(user.getId());

        Optional<User> found = userService.findUserById(user.getId());
        assertTrue(found.isPresent());
        assertEquals("홍길동", found.get().getName());
    }
}
