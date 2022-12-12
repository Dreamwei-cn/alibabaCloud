package org.com.dream.cloud.business.reg.controller;

import org.apache.dubbo.config.annotation.DubboReference;

import org.com.dream.cloud.admin.api.service.IBaseSerivceTest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/con")
public class TestController {

    @DubboReference
    private IBaseSerivceTest baseService;
    @RequestMapping("/test")
    public String test(){
        System.out.println("sssssssssssyaya");
        return  baseService.test();
    }
}
