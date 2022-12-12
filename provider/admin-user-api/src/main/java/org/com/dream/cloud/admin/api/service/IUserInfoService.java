package org.com.dream.cloud.admin.api.service;

import org.com.dream.cloud.admin.api.entity.UserInfo;


public interface IUserInfoService  {

    int insertUserInfo(UserInfo userInfo);

    UserInfo queryUserInfoByName(String userName);

    default String test(){
        System.out.println("");
        return "";
    }
}
