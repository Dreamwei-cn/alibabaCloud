package org.com.dream.cloud.configuration;

import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DubboSentinelConfigration {

    @Bean
    public SentinelResourceAspect sentinelResourceAspect(){
        return  new SentinelResourceAspect();
    }
}
