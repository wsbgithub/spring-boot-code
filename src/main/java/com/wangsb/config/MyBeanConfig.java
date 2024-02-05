package com.wangsb.config;

import com.wangsb.model.MyBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnJava;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.boot.system.JavaVersion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangshenbing
 * @date 2024/02/06
 **/

@Configuration

public class MyBeanConfig {
    //@Bean
    //@ConditionalOnResource(resources = "config1.properties")
    //public MyBean myBean() {
    //    MyBean myBean = new MyBean();
    //    myBean.setName("wangsb");
    //    return myBean;
    //}

}