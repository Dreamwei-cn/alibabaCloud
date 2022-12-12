package org.com.dream.cloud.provider.service;

import org.apache.dubbo.config.annotation.DubboService;
import org.com.dream.cloud.admin.api.service.IBaseSerivceTest;
import org.com.dream.cloud.provider.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import javax.annotation.Resource;

@DubboService
@RefreshScope
public class BaseService implements IBaseSerivceTest {

    @Value("${DDdd.value}")
    private String value;

    private byte[] bytes = new byte[0];

    @Resource
    private UserInfoMapper userInfoMapper;
    @Override
    // 1`在整个方法加 synchronized
    public synchronized String test(){

        // 2 或者把业务逻辑用 synchronized 包起来
        synchronized (bytes) {
            userInfoMapper.selectByPrimaryKey(1L);
        }


        return  "this is dubbo test :" + value ;

    }
}
