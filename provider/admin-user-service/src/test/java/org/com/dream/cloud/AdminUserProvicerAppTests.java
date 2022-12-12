package org.com.dream.cloud;

import org.com.dream.cloud.provider.mapper.UserInfoMapper;
import org.com.dream.cloud.admin.api.service.IAuthUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AdminUserProvicerAppTests {


    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    public void test(){
        userInfoMapper.selectByPrimaryKey(1L);
    }
    @Autowired
    private IAuthUserService userService;

    @Test
    public void testUserService(){
        userService.selectByName("dream");
    }
}
