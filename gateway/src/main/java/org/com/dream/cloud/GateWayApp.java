package org.com.dream.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.http.codec.support.DefaultServerCodecConfigurer;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.cors.reactive.CorsUtils;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;


@SpringBootApplication
@EnableDiscoveryClient
public class GateWayApp {
    private static final String all = "*";
    private static final String max_age = "3600L";

    @Bean
    public RouteDefinitionLocator discoveryClientRouteDefinitionLocation(ReactiveDiscoveryClient discoveryClient, DiscoveryLocatorProperties properties){
        return  new DiscoveryClientRouteDefinitionLocator(discoveryClient, properties);
    }
    @Bean
    public ServerCodecConfigurer serverCodecConfigurer(){
        return  new DefaultServerCodecConfigurer();
    }

    @Bean
    public WebFilter corsFilter(){
        return  (ServerWebExchange ctx, WebFilterChain chain) ->{
            ServerHttpRequest request = ctx.getRequest();
            if (!CorsUtils.isCorsRequest(request)){
                return  chain.filter(ctx);
            }
            HttpHeaders requestHeaders = request.getHeaders();
            ServerHttpResponse response = ctx.getResponse();
            HttpMethod requertMethod = requestHeaders.getAccessControlRequestMethod();
            HttpHeaders headers = response.getHeaders();

            headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, requestHeaders.getOrigin());
            headers.addAll(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, requestHeaders.getAccessControlRequestHeaders());

            if (requertMethod != null) {
                headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, requertMethod.name());
            }
            headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS,"true");
            headers.add(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, all);
            headers.add(HttpHeaders.ACCESS_CONTROL_MAX_AGE, max_age);
            if (request.getMethod() == HttpMethod.OPTIONS){
                response.setStatusCode(HttpStatus.OK);
                return Mono.empty();
            }
            return  chain.filter(ctx);
        };
    }
    public static void main(String[] args) {
        SpringApplication.run(GateWayApp.class, args);
    }
}
