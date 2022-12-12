package org.com.dream.cloud;

import org.com.dream.cloud.configuration.DubboSentinelConfigration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *  服务提供者  与数据库交互
 *    dubbo 整合sentinel  启动环境变量
 *  *    -Djava.net.preferIPv4Stack=true
 *  *    -Dcsp.sentinel.api.port=8720
 *  *    -Dprojecet.name=admin-service
 *  *    -Dcsp.sentinel.dashboard.server=127.0.0.1:8080
 *  *    -Dcsp.sentinel.log.use.pid=true
 *
 */
@SpringBootApplication(scanBasePackageClasses = {AdminUserProviderApp.class, DubboSentinelConfigration.class})
@EnableDiscoveryClient
public class AdminUserProviderApp {
    public static void main(String[] args) {
        SpringApplication.run(AdminUserProviderApp.class, args);
    }
}
