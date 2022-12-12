package org.com.dream.cloud.provider.service.fallback;

import lombok.extern.slf4j.Slf4j;
import org.com.dream.cloud.admin.api.entity.AuthUser;

@Slf4j
public class AuthUserServiceFallback {

    public static AuthUser selectByNameFallBack(String name, Throwable ex){
        log.warn("invoke selectByName fallBack", ex.getClass().getTypeName());
        return  null;
    }
}
