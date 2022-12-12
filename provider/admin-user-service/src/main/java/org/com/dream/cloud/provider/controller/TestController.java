package org.com.dream.cloud.provider.controller;

import org.apache.dubbo.config.annotation.DubboReference;
import org.com.dream.cloud.provider.service.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
//    @DubboReference
//    private BaseService baseService;
//    public String test(){
//        return  baseService.test();
//    }
}
