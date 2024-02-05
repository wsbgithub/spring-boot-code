package com.wangsb;

import com.wangsb.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
class SpringBootCodeApplicationTests {

    @Test
    void contextLoads() {
    }
    @Test
    public void test(){
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext("com.wangsb");
        UserService userService = applicationContext.getBean("userService",UserService.class);
        userService.registe();
        userService.orderedOfUnPay();
        userService.birthdayGreeting();
    }
}