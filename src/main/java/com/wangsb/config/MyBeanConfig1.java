package com.wangsb.config;

import com.wangsb.model.MyBean;
import org.springframework.boot.autoconfigure.condition.*;
import org.springframework.boot.system.JavaVersion;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author wangshenbing
 * @date 2024/02/06
 **/

@Configuration

//@ConditionalOnBean(name = "myHttpClient")
//@ConditionalOnMissingBean(name = "myHttpClient1")
//@ConditionalOnSingleCandidate(ApplicationListener.class)
//@ConditionalOnExpression("${myapp.enabled.flag:true}")
public class MyBeanConfig1 {


    @Bean
    //@ConditionalOnJava(JavaVersion.ELEVEN)
    //@ConditionalOnProperty(
    //        value = "test.property.value-test"
    //)
    //@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
    public MyBean myBean() {
        MyBean myBean = new MyBean();
        myBean.setName("wangsb");
        return myBean;


    }

}