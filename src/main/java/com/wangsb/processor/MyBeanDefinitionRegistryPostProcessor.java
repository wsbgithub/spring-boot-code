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