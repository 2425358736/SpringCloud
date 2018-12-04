package com.liuzhiqiang.FeignClientservice.Fuse;

import com.liuzhiqiang.FeignClientservice.IndexService;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lzq on 2018/12/4.
 * 熔断器。。。请求失败返回
 */
@Component
public class IndexServiceFuse implements IndexService {
    @Override
    public Map<String, Object> index() {
        Map<String,Object> map = new HashMap<>();
        map.put("eorr", "连接失败");
        return map;
    }
}
