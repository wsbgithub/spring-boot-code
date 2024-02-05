package com.wangsb;

import com.wangsb.config.HttpClientConfig;
import com.wangsb.config.MyBeanConfig;
import com.wangsb.model.Dog;
import com.wangsb.model.MyBean;
import com.wangsb.model.MyHttpClient;
import com.wangsb.service.UserService;
import org.assertj.core.api.Assert;
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
    public void test() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.wangsb");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.registe();
        userService.orderedOfUnPay();
        userService.birthdayGreeting();
    }

    @Test
    public void testConditionalOnClass() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.wangsb");
        MyHttpClient myHttpClient = applicationContext.getBean("myHttpClient", MyHttpClient.class);
        System.out.println("myHttpClient = " + myHttpClient);
    }
    @Test
    public void testConditionalOnMissingClass() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.wangsb");
        MyHttpClient myHttpClient = applicationContext.getBean("myHttpClient", MyHttpClient.class);
        System.out.println("myHttpClient = " + myHttpClient);
    }
    @Test
    public void testConditionalOnPropertyConfig() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.wangsb");
        MyBean myBean = applicationContext.getBean("myBean", MyBean.class);
        System.out.println("myBean = " + myBean);
    }
    @Test
    public void testConditionalOnResource() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.wangsb");
        MyBean myBean = applicationContext.getBean("myBean", MyBean.class);
        System.out.println("myBean = " + myBean);
    }
    @Test
    public void testConditionalOnWebApplication() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.wangsb");
        MyBean myBean = applicationContext.getBean("myBean", MyBean.class);
        System.out.println("myBean = " + myBean);
    }
    @Test
    public void testConditionalOnBean() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.wangsb");
        MyBean myBean = applicationContext.getBean("myBean", MyBean.class);
        System.out.println("myBean = " + myBean);
    }
    @Test
    public void testConditionalOnMissingBean() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.wangsb");
        MyBean myBean = applicationContext.getBean("myBean", MyBean.class);
        System.out.println("myBean = " + myBean);
    }
    @Test
    public void testConditionalOnSingleCandidate() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.wangsb");
        MyBean myBean = applicationContext.getBean("myBean", MyBean.class);
        System.out.println("myBean = " + myBean);
    }
    @Test
    public void testConditionalOnExpression() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.wangsb");
        MyBean myBean = applicationContext.getBean("myBean", MyBean.class);
        System.out.println("myBean = " + myBean);
    }
    @Test
    public void testConditionalOnJava() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.wangsb");
        MyBean myBean = applicationContext.getBean("myBean", MyBean.class);
        System.out.println("myBean = " + myBean);
    }


    @Test
    public void testBeanDefinitionRegistryPostProcessor(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.wangsb");
        Dog dog = ((Dog) context.getBean("dog"));
        System.out.println(dog.getName());
        System.out.println(dog.getColor());
    }
}
