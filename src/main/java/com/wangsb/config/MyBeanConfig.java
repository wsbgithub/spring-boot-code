package com.wangsb.config;

import com.wangsb.model.MyBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangshenbing
 * @date 2024/02/06
 **/

@Configuration

public class MyBeanConfig {
    @Bean
    @ConditionalOnResource(resources = "config.properties")
    public MyBean myBean() {
        MyBean myBean = new MyBean();
        myBean.setName("wangsb");
        return myBean;


    }

}