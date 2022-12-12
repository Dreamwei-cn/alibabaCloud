package org.com.dream.cloud.provider.service.impl;

import org.apache.dubbo.config.annotation.DubboService;
import org.com.dream.cloud.admin.api.entity.UserInfo;
import org.com.dream.cloud.admin.api.entity.UserInfoExample;
import org.com.dream.cloud.admin.api.service.IUserInfoService;
import org.com.dream.cloud.provider.mapper.UserInfoMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;

@Service
@DubboService(version = "0.0.1")
public class UserServiceImpl implements IUserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;
    @Resource
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public int insertUserInfo(UserInfo userInfo) {
        userInfo.setPassword(bCryptPasswordEncoder.encode("123456"));
        return userInfoMapper.insert(userInfo);
    }

    @Override
    public UserInfo queryUserInfoByName(String userName) {
        UserInfoExample example = new UserInfoExample();
        example.createCriteria().andNameEqualTo(userName);
        userInfoMapper.selectByExample(example);
        return userInfoMapper.selectByName(userName);
    }

}
