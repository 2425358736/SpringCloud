package com.liuzhiqiang.FeignClientservice;

import com.liuzhiqiang.FeignClientservice.Fuse.IndexServiceFuse;
import com.liuzhiqiang.config.springCloudConfig.FeignConfig;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Created by JJJ on 2017/9/11.
 */
@FeignClient(value = "service-two", configuration = FeignConfig.class, fallback = IndexServiceFuse.class)
public interface IndexService {
    @RequestMapping(method = RequestMethod.GET, value = "/index")
    Map<String,Object> index();
}
