package org.com.dream.cloud.business.reg.controller;

import org.apache.dubbo.config.annotation.DubboReference;
import org.com.dream.cloud.admin.api.service.IBaseSerivceTest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reg")
public class EchoTestController {

    @DubboReference
    private IBaseSerivceTest baseService;

    @RequestMapping("{id}")
    public String testEcho(@PathVariable("id") String id){
        System.out.println(id);
        return  baseService.test();
    }
}
