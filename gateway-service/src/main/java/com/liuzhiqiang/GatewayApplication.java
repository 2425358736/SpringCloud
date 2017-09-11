package com.liuzhiqiang;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by JJJ on 2017/9/11.
 */
@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class GatewayApplication extends WebMvcConfigurerAdapter implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("服务器已起动");
    }
}
