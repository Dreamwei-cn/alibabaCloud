package org.com.dream.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = "org.com.dream.cloud")
@EnableDiscoveryClient
public class AdminConsumerApp {

    public static void main(String[] args) {
        SpringApplication.run(AdminConsumerApp.class, args);
    }
}
