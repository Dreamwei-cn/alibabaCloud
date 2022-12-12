package org.com.dream.cloud.interceptor.feign;

import feign.Request;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

public class FeignRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert  attributes != null;
        HttpServletRequest request = attributes.getRequest();

        Enumeration<String> headerNames = request.getHeaderNames();
        if (headerNames != null){
            while (headerNames.hasMoreElements()){
                String name = headerNames.nextElement();
                String value = request.getHeader(name);
                requestTemplate.header(name, value);
            }
        }

        Enumeration<String> parameterNames = request.getParameterNames();

        StringBuilder builder = new StringBuilder();
        if (parameterNames != null){
            while (parameterNames.hasMoreElements()){
                String name = parameterNames.nextElement();
                String value = request.getParameter(name);
                if ("access_token".equals(name)){
                    requestTemplate.header("authorization","Bearer " + value);
                }else {
                    builder.append(name).append("=").append(value).append("&");
                }

            }
        }
        if (builder.length() > 0){
            builder.deleteCharAt(builder.length() -1);
            requestTemplate.body(builder.toString());
        }
    }
}
