package com.liuzhiqiang.config.aop;

/**
 * Created by JJJ on 2017/2/21.
 */

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by jiaobuchong on 12/23/15.
 */
@Aspect   //定义一个切面
@Component
public class LogRecordAspect {

    // 定义切点Pointcut
    @Pointcut("execution(* com.liuzhiqiang..*.*(..))")
    public void excudeService() {
    }

    //环绕通知
    //@Around("excudeService()  && @annotation(monitor)")
    public Object doAround(ProceedingJoinPoint pjp, Monitor monitor) throws Throwable {
        return null;
    }

    //后置通知
    @After("excudeService() && @annotation(monitor)")
    public void afterMethod(JoinPoint joinPoint, Monitor monitor) {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        //请求路径
        String url = request.getRequestURL().toString();
        //请求方式
        String method = request.getMethod();
        //请求参数
        String queryString = request.getQueryString();
        if (StringUtils.pathEquals(method, "POST")) {
            queryString = doPost(request);
        }
        String ip = request.getHeader("X-Forwarded-For"); //取得实际地址。如果使用了匿名代理的话
        String user_agent = "";
        if (StringUtils.isEmpty(ip)) { //取不到forwarded地址就取实际的ip地址
            user_agent = request.getRemoteAddr(); //代理地址
        } else {
            ip = ip.split(",")[0];//如果有多级反向代理，返回的是一组ip，取第一个
        }
        //操作内容
        String logTitle = monitor.logTitle();
        //操作类别
        String logType = monitor.logType();

        String text = monitor.text();
        System.out.println("url="+url+"method="+method+"queryString="+queryString+"ip="+ip+"text="+text);
    }

    //前置通知
    @Before("excudeService()")
    public void beforeMethod(JoinPoint joinPoint) {

    }

    //返回通知
    @AfterReturning("excudeService() && @annotation(monitor)")
    public void afterReturningMethod(JoinPoint joinpoint, Monitor monitor) {
    }

    //异常通知
    @AfterThrowing("excudeService()")
    public void afterThrowingMethod(JoinPoint joinPoint) {
    }

    protected static String doPost(HttpServletRequest request) {
        Map<String, String[]> params = request.getParameterMap();
        String queryString = "";
        for (String key : params.keySet()) {
            String[] values = params.get(key);
            for (int i = 0; i < values.length; i++) {
                String value = values[i];
                queryString += key + "=" + value + "&";
            }
        }
        // 去掉最后一个空格
        queryString = queryString.substring(0, queryString.length() - 1);
        return queryString;

    }

       /**
     * 判断ajax请求
     * @param request
     * @return
     */
    boolean isAjax(HttpServletRequest request){
        return  (request.getHeader("X-Requested-With") != null  && "XMLHttpRequest".equals( request.getHeader("X-Requested-With").toString())   ) ;
    }

}