package com.liuzhiqiang.config;

import com.liuzhiqiang.config.Interceptor.LoginIntercept;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by JJJ on 2017/9/7.
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    //静态资源放过
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    //注入连接器
    @Bean
    LoginIntercept loginIntercept() {
        return new LoginIntercept();
    }
    //加载拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(loginIntercept()).addPathPatterns("/**")
                .excludePathPatterns("/system/verificationUser")
                .excludePathPatterns("/FeignClent")
                .excludePathPatterns("/login2")
                .excludePathPatterns("/index")
                .excludePathPatterns("/error");
        super.addInterceptors(registry);
    }

}
