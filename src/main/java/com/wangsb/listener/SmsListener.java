package com.wangsb.listener;

import com.wangsb.event.SmsEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author wangshenbing
 */
@Component
public class SmsListener implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if (applicationEvent instanceof SmsEvent) {
            SmsEvent smsEvent = (SmsEvent) applicationEvent;
            System.out.println("监听到事件名称:" + smsEvent.getEventName());
            System.out.println("开始执行事件:" + smsEvent.getEventName());
            Map<String, Object> smsObj = smsEvent.getSmsObj();
            String userName = smsObj.get("userName").toString();
            String phone = smsObj.get("phone").toString();
            String msgContent = smsObj.get("msgContent").toString();
            System.out.println("msgContent = " + msgContent);
            System.out.println("userName = " + userName);
            System.out.println("phone = " + phone);
        }
    }
}