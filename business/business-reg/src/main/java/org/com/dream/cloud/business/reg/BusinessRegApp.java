package org.com.dream.cloud.business.reg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BusinessRegApp {

    public static void main(String[] args) {
        SpringApplication.run(BusinessRegApp.class, args);
    }
}
