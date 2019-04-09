package com.fjd.fchat.api.v1.service;

import com.fjd.fchat.bo.User;
import com.fjd.fchat.repo.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class UserControllerTest {
    @Mock
    UserRepository userRepository;
    @InjectMocks
    UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testAddNewUser() {
        String result = userController.addNewUser("name", "email");
        Assertions.assertEquals("Saved", result);
    }

    @Test
    void testCreate() {
        String result = userController.create(new User());
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    void testList() {
        List<User> result = userController.list();
        Assertions.assertEquals(Arrays.<User>asList(), result);
    }
}
