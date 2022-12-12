package org.com.dream.cloud.provider.service.impl;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.apache.dubbo.config.annotation.DubboService;
import org.com.dream.cloud.admin.api.entity.AuthUser;

import org.com.dream.cloud.commons.api.base.service.impl.BaseServiceImpl;
import org.com.dream.cloud.provider.mapper.AuthUserMapper;
import org.com.dream.cloud.admin.api.service.IAuthUserService;
import org.com.dream.cloud.provider.service.fallback.AuthUserServiceFallback;
import org.springframework.stereotype.Service;


@DubboService(version = "0.0.1")
@Service
public class AuthUserServiceImpl extends BaseServiceImpl<AuthUserMapper, AuthUser> implements IAuthUserService {


    @Override
    @SentinelResource(value = "selectByName", fallbackClass = AuthUserServiceFallback.class, fallback = "selectByNameFallBack")
    public AuthUser selectByName(String name) {
//        if ("admin".equals(name))
//            throw new IllegalArgumentException("Invoke args");
        return getBaseMapper().selectByName(name);
    }
}
