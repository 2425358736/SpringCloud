package com.liuzhiqiang;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JJJ on 2017/9/11.
 */
@SpringBootApplication(scanBasePackages = "com.liuzhiqiang")
@EnableEurekaClient
@EnableWebMvc
@EnableFeignClients
@Controller
public class ServicetTwoApplication extends WebMvcConfigurerAdapter implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(ServicetTwoApplication.class, args);
    }

    // 跟目录重定向
    @RequestMapping("/")
    @ResponseBody
    Map<String,Object> home() {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("作者：","刘志强");
        return map;
    }

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("服务器已起动");
    }
}
