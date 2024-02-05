package com.wangsb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * @author wangshenbing
 */
@SpringBootApplication
public class SpringBootCodeApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringBootCodeApplication.class, args);
        run.getApplicationStartup().start("test").getName();
    }

}
