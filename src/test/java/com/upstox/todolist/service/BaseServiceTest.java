package com.upstox.todolist.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BaseServiceTest {

    @BeforeEach
    void setUp(TestInfo testInfo) {
        System.out.println("*********** TEST STARTS ***********");
        System.out.println("TESTING {} method " + testInfo.getDisplayName());
    }

    @AfterEach
    void tearDown() {
        System.out.println("*********** TEST ENDS ***********");
    }

}
