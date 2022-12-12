package org.com.dream.cloud.business.reg.controller;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.http.HttpStatus;
import org.com.dream.cloud.admin.api.entity.UserInfo;
import org.com.dream.cloud.admin.api.service.IUserInfoService;
import org.com.dream.cloud.commons.api.dto.ResponseResult;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *  用户注册
 *
 */
@RestController
@RequestMapping("/user")
public class UserInfoController {

    @DubboReference(version = "0.0.1")
    private IUserInfoService userInfoService;

    /**
     *
     * @param userInfo
     * @return ResponseResult
     */
    @PostMapping("/reg")
    public ResponseResult<UserInfo> reg(@RequestBody UserInfo userInfo){
        if (valiDataReg(userInfo)){
            userInfoService.insertUserInfo(userInfo);
        }
        return new ResponseResult<UserInfo>(HttpStatus.SC_OK).setData(userInfo);
    }

    private boolean valiDataReg(UserInfo userInfo){
        return !ObjectUtils.nullSafeEquals(userInfo.getName(),"");
    }
}
