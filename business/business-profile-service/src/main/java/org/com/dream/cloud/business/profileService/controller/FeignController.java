package org.com.dream.cloud.business.profileService.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.apache.dubbo.config.annotation.DubboReference;
import org.com.dream.cloud.admin.api.entity.AuthUser;
import org.com.dream.cloud.admin.api.service.IAuthUserService;
import org.com.dream.cloud.business.dto.UserParam;
import org.com.dream.cloud.business.profileService.controller.fallBack.FeignControllerFallBack;
import org.com.dream.cloud.commons.api.dto.ResponseResult;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
public class FeignController {

    @DubboReference(version = "0.0.1")
    private IAuthUserService authUserService;

    @GetMapping("/user/{userName}")
    @SentinelResource(value = "userInfo", fallback = "userInfoFallBack", fallbackClass = FeignControllerFallBack.class)
    public ResponseResult<AuthUser> userInfo(@PathVariable("userName") String userName){

        AuthUser authUser = authUserService.selectByName(userName);
        return new ResponseResult<AuthUser>(20000,"成功").setData(authUser);
    }
    @PostMapping(value = "/users")
    public  ResponseResult<Void> update(@RequestBody UserParam userParam){
        AuthUser authUser = new AuthUser();
        BeanUtils.copyProperties(userParam, authUser);
        authUser.setPersonid(20L);
        authUser.setUsername("admin");
       int num = authUserService.update(authUser);
       if (num > 0){
           return  new ResponseResult<>(ResponseResult.CodeStatus.OK,"更新成功");
       }else {
           return  new ResponseResult<>(ResponseResult.CodeStatus.FAIL,"更新失败！");
       }

    }
}
