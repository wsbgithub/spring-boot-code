package com.wangsb.event;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

import java.util.Map;

/**
 * @author wangshenbing
 */
@Getter
@Setter
public class SmsEvent extends ApplicationEvent {
    private String eventType = "短信发送事件";
    private String eventName;
    private Map<String, Object> smsObj;

    public SmsEvent(Object source) {
        super(source);
    }
}