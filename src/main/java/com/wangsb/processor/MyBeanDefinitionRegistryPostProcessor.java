package com.wangsb.processor;

import com.wangsb.model.Dog;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @author wangshenbing
 */
@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    /**
     * 对敏感信息的解密处理，比如数据库连接信息加密和解密：在实际的业务开发中，在配置文件中明文配置mysq，
     * redis的密码实际上是不安全的，需要配置加密后的密码信息；但是把加密后的密码信息注入的数据源中，
     * 去连接mysql数据库肯定会连接异常，因为mysql并不知道你的加密方式和加密方法。
     * 这就会产生一个需求：需要在配置文件中配置的数据库信息是加密的，但是在把密码信息注入数据源前在程序里解密处理。
     * <p>
     * BeanFactoryPostProcessor正好可以解决这个问题，在真正使用到数据源去连接数据库前，
     * 读取到加密信息，进行解密处理，再用解密后的信息替换掉Spring容器中加密信息。
     *
     * @param registry the bean definition registry used by the application context
     * @throws BeansException
     */
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        //手工定义一个beanDefinition实例
        RootBeanDefinition beanDefinition = new RootBeanDefinition();
        //给beanDefinition填充属性
        beanDefinition.setBeanClass(Dog.class);
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        PropertyValue propertyValue1 = new PropertyValue("name", "旺财");
        PropertyValue propertyValue2 = new PropertyValue("color", "黑色");
        propertyValues.addPropertyValue(propertyValue1);
        propertyValues.addPropertyValue(propertyValue2);
        beanDefinition.setPropertyValues(propertyValues);
        //注册手工定义的beanDefinition
        registry.registerBeanDefinition("dog", beanDefinition);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("-----------start------------");
        //根据类名取出手工注册的beanDefinition
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("dog");
        System.out.println(beanDefinition.getBeanClassName());
        //根据类从容器中取出手工注册的beanDefinition所描述的实例bean
        Dog dog = beanFactory.getBean(Dog.class);
        System.out.println(dog.getName());
        System.out.println(dog.getColor());
        System.out.println("-----------end------------");
    }
}