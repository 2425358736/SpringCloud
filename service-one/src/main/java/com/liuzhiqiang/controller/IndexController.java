package com.liuzhiqiang.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liuzhiqiang.FeignClientservice.IndexService;
import com.liuzhiqiang.config.aop.Monitor;
import com.liuzhiqiang.config.redis.IRedisService;
import com.liuzhiqiang.dao.UserMapper;
import com.liuzhiqiang.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by JJJ on 2017/9/7.
 */
@RestController
public class IndexController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private IRedisService iRedisService;
    @Autowired
    private IndexService indexService;


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
        User user = userMapper.selectByPrimaryKey(new Long("1"));
        modelMap.put("name","liuzhiqiang");
        modelMap.put("user",user);
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
        List<User> list = userMapper.gitListUser();
        PageInfo pageInfo = new PageInfo(list);
        Page page = (Page) list;
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("PageInfo",pageInfo);
        //map.put("Page",page);
        return map;
    }
    @RequestMapping(value = "/FeignClent",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> FeignClent(){
        Map<String,Object> map = indexService.index();
        return map;
    }

}
