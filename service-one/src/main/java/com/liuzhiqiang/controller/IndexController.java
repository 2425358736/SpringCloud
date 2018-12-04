package com.liuzhiqiang.controller;

import com.github.pagehelper.PageHelper;
import com.liuzhiqiang.FeignClientservice.IndexService;
import com.liuzhiqiang.config.aop.Monitor;
import com.liuzhiqiang.config.redis.IRedisService;
import com.liuzhiqiang.domain.sys.SysUser;
import com.liuzhiqiang.domain.sys.vo.SysUserVo;
import org.bouncycastle.voms.VOMSAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by JJJ on 2017/9/7.
 */
@RestController
public class IndexController {
    @Autowired
    private IRedisService iRedisService;
    @Autowired
    private IndexService indexService;
    @Autowired
    public UserDetailsService userDetailsService;


    @RequestMapping(value = "/index/{id}")
    @CrossOrigin //跨域返回json注解
    public Map<String,Object> view(@PathVariable Integer id) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("id",id);
        return map;
    }
    @RequestMapping(value = "/index",method = RequestMethod.POST)
    @ResponseBody //返回json注解
    public Map<String,Object> index(Integer id) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("id",id);
        return map;
    }
    //mybaits测试
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public ModelAndView getindex(Integer id, ModelMap modelMap) {
        modelMap.put("name","liuzhiqiang");
        return new ModelAndView("index",modelMap);
    }
    //aop redis测试
    @Monitor(logTitle = "aop测试", logType = "aop",text = "12345678")//自定义注解
    @RequestMapping(value = "/redis",method = RequestMethod.GET)
    public ModelAndView redis(Integer id, ModelMap modelMap) {
        iRedisService.set("name",id.toString());
        modelMap.put("redis",iRedisService.get("name"));
        return new ModelAndView("index",modelMap);
    }
    //分页插件测试
    @RequestMapping(value = "/page",method = RequestMethod.GET)
    public Map<String,Object> page(HttpServletRequest request, Integer pageNum, Integer pageSize) {
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 10 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        Map<String,Object> map = new HashMap<String,Object>();
        return map;
    }
    @RequestMapping(value = "/FeignClent",method = RequestMethod.GET)
    @PreAuthorize("hasAnyAuthority('2222')")
    @ResponseBody
    public Map<String,Object> FeignClent(){
        Map<String,Object> map = indexService.index();
        return map;
    }

    @RequestMapping("login")
    public ModelAndView login(ModelMap modelMap) {
        return new ModelAndView("login",modelMap);
    }


    @RequestMapping("login2")
    public String login2(HttpServletRequest request) {
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken("1111", "2222");
        SecurityContextHolder.getContext().setAuthentication(authRequest);
        HttpSession session = request.getSession();
        session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext()); // 这个非常重要，否则验证后将无法登陆
        return authRequest.getName();
    }
}
