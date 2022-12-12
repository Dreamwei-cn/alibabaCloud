package org.com.dream.cloud.configuration;

import feign.RequestInterceptor;
import org.com.dream.cloud.interceptor.feign.FeignRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignRequestConfig {

    @Bean
    public RequestInterceptor requestInterceptor(){
        return  new FeignRequestInterceptor();
    }
}
