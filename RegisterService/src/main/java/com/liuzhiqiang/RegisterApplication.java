package com.liuzhiqiang;

/**
 * Created by JJJ on 2017/9/11.
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
@SpringBootApplication
@EnableEurekaServer
public class RegisterApplication {
    public static void main(String[] args) {
        SpringApplication.run(RegisterApplication.class, args);
    }

}
