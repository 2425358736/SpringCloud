package com.liuzhiqiang.ImplController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JJJ on 2017/9/11.
 */
@RestController
public class IndexController {
    @RequestMapping("index")
    public Map<String, Object> index() {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("作者:","刘志强");
        return map;
    }
}
