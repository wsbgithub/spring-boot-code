package com.wangsb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionMessage;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.util.Map;

/**
 * @author wangshenbing
 */
@SpringBootApplication
public class SpringBootCodeApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringBootCodeApplication.class, args);
        Map<String, Object> systemEnvironment = run.getEnvironment().getSystemEnvironment();
        systemEnvironment.forEach((k,v)-> System.out.println("k ,v= " + k+v));



    }

}
