package com.liuzhiqiang.controller;

import com.github.pagehelper.PageHelper;
import com.liuzhiqiang.FeignClientservice.IndexService;
import com.liuzhiqiang.config.aop.Monitor;
import com.liuzhiqiang.config.redis.IRedisService;
import com.liuzhiqiang.domain.sys.SysUser;
import com.liuzhiqiang.mapper.sys.SysUserMapper;
import com.liuzhiqiang.until.CommonResult;
import com.liuzhiqiang.until.Md5Utils;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
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
    public SysUserMapper sysUserMapper;
    @Autowired
    private AmqpTemplate rabbitTemplate;


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

    // security测试
    @RequestMapping(value = "/FeignClent2",method = RequestMethod.GET)
    @PreAuthorize("hasAnyAuthority('2222')")
    @ResponseBody
    public Map<String,Object> FeignClent2(){
        Map<String,Object> map = indexService.index();
        return map;
    }


    // Feign测试
    @RequestMapping(value = "/FeignClent",method = RequestMethod.GET)
//    @PreAuthorize("hasAnyAuthority('2222')")
    @ResponseBody
    public Map<String,Object> FeignClent(){
        Map<String,Object> map = indexService.index();
        return map;
    }


    // mq测试
    @RequestMapping(value = "/FeignClent1",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> FeignClent1(){
        rabbitTemplate.convertAndSend("3", new Date());
        return new HashMap<>();
    }
    @RequestMapping("login")
    public ModelAndView login(ModelMap modelMap) {
        return new ModelAndView("login",modelMap);
    }


    @RequestMapping("login2")
    @CrossOrigin
    public CommonResult<String> login2(@RequestBody SysUser sysUser, HttpSession session) {
        sysUser.setPassWord(Md5Utils.md5(sysUser.getPassWord()));
        SysUser user = sysUserMapper.verificationUser(sysUser);
        if (user != null) {
            UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(sysUser.getLoginName(),sysUser.getPassWord());
            SecurityContextHolder.getContext().setAuthentication(authRequest);
            session.setAttribute("user", user);
            iRedisService.set(user.getId().toString(), session.getId());
            return CommonResult.successReturn("登录成功", "登陆成功");
        } else {
            return CommonResult.errorReturn(150,"账号密码不匹配");
        }
    }
}
