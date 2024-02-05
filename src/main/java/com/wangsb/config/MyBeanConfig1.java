package com.wangsb.config;

import com.wangsb.model.MyBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author wangshenbing
 * @date 2024/02/06
 **/

@Configuration
//@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
@ConditionalOnBean(name = "myHttpClient")
public class MyBeanConfig1 {

    @Bean
    public MyBean myBean() {
        MyBean myBean = new MyBean();
        myBean.setName("wangsb");
        return myBean;


    }

}