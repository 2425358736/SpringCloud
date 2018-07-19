package com.liuzhiqiang.saas.react.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liuzhiqiang.saas.react.code.ext.DateConvertEditor;
import com.liuzhiqiang.saas.react.code.ext.StringEscapeEditor;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

import javax.security.sasl.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by JJJ on 2017/9/27.
 */
public abstract class BaseController {

    /**
     * 控制器本来就是单例，这样似乎更加合理
     */
    protected Logger logger = LoggerFactory.getLogger(getClass());


    /**
     * 将前台传递过来的日期格式的字符串，自动转化为Date类型
     *
     * @param binder
     */
    @InitBinder
    public void initBinder(ServletRequestDataBinder binder) {
        /**
         * 自动转换日期类型的字段格式
         */
        binder.registerCustomEditor(Date.class, new DateConvertEditor());
        /**
         * 防止XSS攻击
         */
        binder.registerCustomEditor(String.class, new StringEscapeEditor());
    }

}
