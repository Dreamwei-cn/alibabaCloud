package org.com.dream.cloud.provider.testService;


import org.com.dream.cloud.admin.api.entity.UserInfo;
import org.com.dream.cloud.admin.api.service.IUserInfoService;
import org.com.dream.cloud.provider.base.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;

public class TestUserService extends BaseTest {


    @Resource
    private IUserInfoService userInfoService;
    @Resource
    private BCryptPasswordEncoder passwordEncoder;
    @Test
    public void testInsert(){
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1L);
        userInfo.setName("test");
        userInfo.setPassword(passwordEncoder.encode("123456"));
        int i = userInfoService.insertUserInfo(userInfo);
        Assert.assertEquals(i,1L);
    }
    @Test
    public void testSelectByName(){
        UserInfo userInfo = userInfoService.queryUserInfoByName("dream");
    }
}
