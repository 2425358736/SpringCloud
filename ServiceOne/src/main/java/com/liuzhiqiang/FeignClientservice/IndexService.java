package com.liuzhiqiang.FeignClientservice;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Created by JJJ on 2017/9/11.
 */
@FeignClient("ServiceTwo")
public interface IndexService {
    @RequestMapping(method = RequestMethod.GET, value = "/index")
    Map<String,Object> index();
}
