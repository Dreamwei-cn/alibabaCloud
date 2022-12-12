package org.com.dream.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 对oauth2 开放的服务提供者， 同时消费  provider

 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProfileServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(ProfileServiceApp.class,args);
    }
}
