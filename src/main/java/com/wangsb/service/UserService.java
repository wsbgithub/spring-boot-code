package com.wangsb.service;

import com.wangsb.event.SmsEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangshenbing
 */
@Component
public class UserService implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher applicationEventPublisher;
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
  public void registe(){
      System.out.println("新用户张三注册成功");
      System.out.println("触发短信事件....");
      Map<String,Object> smsObj=new HashMap<>();
      smsObj.put("userName", "张三");
      smsObj.put("phone","15503117788" );
      smsObj.put("msgContent", "hello , 欢迎来到csdn");
      SmsEvent smsEvent = new SmsEvent(this);
      smsEvent.setSmsObj(smsObj);
      smsEvent.setEventName("注册成功短信事件");
      this.applicationEventPublisher.publishEvent(smsEvent);
  }
  public void orderedOfUnPay() {
      System.out.println("张三下单成功,但是未付款");
      Map<String,Object> smsObj=new HashMap<>();
      smsObj.put("userName", "张三");
      smsObj.put("phone","15503117788" );
      smsObj.put("msgContent", "张三先生,你好!请尽快付款");
      SmsEvent smsEvent = new SmsEvent(this);
      smsEvent.setSmsObj(smsObj);
      smsEvent.setEventName("下单成功未付款短信事件");
      this.applicationEventPublisher.publishEvent(smsEvent);
  }
  public void birthdayGreeting(){
      System.out.println("今天是张三生日,触发自动短信祝福业务");
      Map<String,Object> smsObj=new HashMap<>();
      smsObj.put("userName", "张三");
      smsObj.put("phone","15503117788" );
      smsObj.put("msgContent", "亲爱张三先生,祝你生日快乐");
      SmsEvent smsEvent = new SmsEvent(this);
      smsEvent.setSmsObj(smsObj);
      smsEvent.setEventName("生日祝福短信事件");
      this.applicationEventPublisher.publishEvent(smsEvent);
  }
}