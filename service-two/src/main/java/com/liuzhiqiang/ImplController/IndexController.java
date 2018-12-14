package com.liuzhiqiang.ImplController;

import com.liuzhiqiang.mapper.sys.SysUserMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JJJ on 2017/9/11.
 */
@RestController
public class IndexController {

    @Autowired
    public SysUserMapper sysUserMapper;

    @RequestMapping("index")
    public Map<String, Object> index() {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("作者:","刘志强");
        return map;
    }


    @RabbitListener(queues = "3")
    public void index3(String helllllo) {
        System.out.println("Receiver  : " + helllllo);
    }
}
