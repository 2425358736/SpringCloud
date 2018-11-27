package com.liuzhiqiang.config.Interceptor;

import com.alibaba.druid.util.StringUtils;
import com.liuzhiqiang.config.redis.IRedisService;
import com.liuzhiqiang.domain.sys.SysUser;
import com.liuzhiqiang.until.CommonResult;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Created by JJJ on 2017/7/19.
 */
public class LoginIntercept implements HandlerInterceptor {

    @Autowired
    public IRedisService redisServer;
    /**
     * 控制器本来就是单例，这样似乎更加合理
     */
    protected Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        logger.info(">>>MyInterceptor1>>>>>>>请求处理之前进行调用");
        String url = httpServletRequest.getRequestURI();
        String methodMB = httpServletRequest.getMethod();
        HttpSession session = httpServletRequest.getSession();
        SysUser sysUser = (SysUser)session.getAttribute("user");
        boolean kg = false;
        if (sysUser == null) {
            kg = true;
        } else {
            String sessionId = redisServer.get(sysUser.getId().toString());
            if (!StringUtils.equals(sessionId,session.getId())) {
                kg = true;
            }
        }
        if (!StringUtils.equals("OPTIONS",methodMB) && kg) {
            PrintWriter writer = null;
            String originHeader = httpServletRequest.getHeader("Origin");
            httpServletResponse.setHeader("Access-Control-Allow-Origin", originHeader);
            httpServletResponse.setCharacterEncoding("UTF-8");
            httpServletResponse.addHeader("Access-Control-Allow-Credentials", "true");
            httpServletResponse.addHeader("Vary", "Origin");
            httpServletResponse.setContentType("application/json; charset=utf-8");
            try {
                JSONObject responseJSONObject = JSONObject.fromObject(CommonResult.errorReturn(120,"登录过期"));
                writer = httpServletResponse.getWriter();
                writer.append(responseJSONObject.toString());
            } catch (IOException e) {
                System.out.println("response error" + e);
            } finally {
                if (writer != null) {
                    writer.close();
                }
            }
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        logger.info(">>>MyInterceptor1>>>>>>>请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        logger.info(">>>MyInterceptor1>>>>>>>在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）");
    }
}
