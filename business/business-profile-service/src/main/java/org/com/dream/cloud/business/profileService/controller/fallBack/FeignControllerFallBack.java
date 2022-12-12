package org.com.dream.cloud.business.profileService.controller.fallBack;


import lombok.extern.slf4j.Slf4j;
import org.com.dream.cloud.admin.api.entity.AuthUser;
import org.com.dream.cloud.commons.api.dto.ResponseResult;

@Slf4j
public class FeignControllerFallBack {

    public static ResponseResult<AuthUser> userInfoFallBack(String userName, Throwable ex){
        log.warn("Invoke err", ex.getClass().getTypeName());
        return  new ResponseResult<AuthUser>(20004,"sentinel 结果");
    }
}
