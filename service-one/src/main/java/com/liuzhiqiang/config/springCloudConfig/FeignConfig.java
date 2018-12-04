package com.liuzhiqiang.config.springCloudConfig;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * Created by lzq on 2018/12/4.
 */
@Configuration
public class FeignConfig {
    @Bean
    public Retryer feginRetryer(){
        Retryer retryer = new Retryer.Default(100, TimeUnit.SECONDS.toMillis(1), 3);
        return retryer;
    }
}
