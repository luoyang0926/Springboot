package com.xy.springboot04;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@DisplayName("junit5 测试类")
public class JunitTest5 {

    @DisplayName("测试 displayname注解")
    @Test
    void testDisPlayName() {
        System.out.println(1);
    }

    @BeforeEach
    void testBeforeEach() {

        System.out.println("测试就要开始了");
    }

    @AfterEach
    void testAfterEach() {

        System.out.println("测试结束了");
    }


}
