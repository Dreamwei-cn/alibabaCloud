package org.com.dream.cloud.code.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.com.dream.cloud.code.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/thread")
@Slf4j
public class OrderTestController {

    private Map<String, Object> mutexCache = new ConcurrentHashMap<>();

    @Autowired
    private OrderService orderService;

    @RequestMapping("/order/{order}")
    public String orderProcess(@PathVariable("order") String order){

//        synchronized (order.intern()){
//
//        }

//        Object mutexKey =  mutexCache.computeIfAbsent(order,k ->new Object());
//        synchronized (mutexKey){
//
//            mutexCache.remove(order);
//        }
//
        log.info("开始");
        orderService.runMethod(order, ()->{
            System.out.println(order);
        });
        log.info("开始");
        return "";
    }
}
