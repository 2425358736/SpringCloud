package com.liuzhiqiang.saas.react;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by JJJ on 2017/9/7.
 */
@SpringBootApplication
@Controller
@EnableWebMvc
public class SpringBootAppliction extends WebMvcConfigurerAdapter implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootAppliction.class, args);
    }

    // 跟目录重定向
    @RequestMapping("/")
    String home() {
        return "redirect:index";
    }

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("服务器已起动");
    }
}
