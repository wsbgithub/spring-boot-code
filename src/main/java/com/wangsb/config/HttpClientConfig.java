package com.wangsb.config;

import com.wangsb.model.MyHttpClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangshenbing
 */
@Configuration

@ConditionalOnClass(name = {"org.apache.http.client.HttpClient"})
//@ConditionalOnMissingClass("org.apache.http.client.HttpClient1")
public class HttpClientConfig {
    /**
     * prefix：属性的前缀，用于指定要匹配的属性的命名空间，默认为空字符串。
     * name：属性的名称，用于指定要匹配的属性的具体名称。
     * havingValue：属性的期望值，用于指定要匹配的属性的值，默认为空字符串。
     * matchIfMissing：如果属性不存在，默认是否匹配。默认为false，即如果属性不存在时不匹配。
     * 根据上述条件，@ConditionalOnProperty注解的作用如下：
     * <p>
     * 如果应用程序的属性myapp.enabled的值为true，则满足条件，注解所在的类或方法将被实例化或配置。
     * 如果应用程序的属性myapp.enabled的值不是true，则不满足条件，注解所在的类或方法将被跳过。
     * 除了上述基本的属性匹配外，@ConditionalOnProperty注解还支持其他一些参数和操作符，例如：
     * <p>
     * value：用于指定完整的属性表达式，等效于使用prefix + name + havingValue。
     * matchIfMissing：是否在属性缺失时匹配条件，默认为false。
     * havingValue支持多个值的情况，例如：havingValue = {"true", "1"}。
     *
     * @return
     */
    @Bean
    //@ConditionalOnProperty(
    //        prefix = "myapp.enabled",
    //        name = "flag",
    //        havingValue = "true"
    //)
    public MyHttpClient myHttpClient() {
        MyHttpClient myHttpClient = new MyHttpClient();
        myHttpClient.setMaxOutTime(2000L);
        return myHttpClient;
    }
}