package com.upstox.todolist.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureTestEntityManager
public class BaseRepositoryTest {

    @BeforeEach
    public void setup(TestInfo testInfo) {
        System.out.println("*********** TEST STARTS ***********");
        System.out.println(("TESTING {} method " + testInfo.getDisplayName()));
    }

    @AfterEach
    public void tearDown() {
        System.out.println("*********** TEST ENDS ***********");
    }
}
