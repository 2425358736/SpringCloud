package com.liuzhiqiang.mq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by lzq on 2018/12/13.
 */
@Configuration
public class RabbitConfig {
    @Bean
    public Queue Queue3() {
        Queue queue3 = new Queue("3", true);
        return queue3;
    }
}
