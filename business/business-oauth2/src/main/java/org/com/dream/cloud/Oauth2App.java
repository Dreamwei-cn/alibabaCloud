package org.com.dream.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 *
 *  登录接口
 *  资源管理
 *  服务对应 user/**
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Oauth2App {
    public static void main(String[] args) {
        SpringApplication.run(Oauth2App.class, args);
    }
}
