package com.wangsb.config;

import com.wangsb.model.MyHttpClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangshenbing
 */
@Configuration
@ConditionalOnClass(name = {"org.apache.http.client.HttpClient"})
public class HttpClientConfig {

    @Bean
    public MyHttpClient myHttpClient() {
        MyHttpClient myHttpClient = new MyHttpClient();
        myHttpClient.setMaxOutTime(2000L);
        return myHttpClient;
    }
}