package org.com.dream.cloud.business.profileFeign.fallback;

import com.alibaba.fastjson.JSON;
import org.com.dream.cloud.admin.api.entity.AuthUser;
import org.com.dream.cloud.business.dto.UserParam;
import org.com.dream.cloud.business.profileFeign.ProfileFeign;
import org.com.dream.cloud.commons.api.dto.ResponseResult;
import org.springframework.stereotype.Component;

@Component
public class ProfileFeignFallback implements ProfileFeign {
    @Override
    public String userInfo(String userName) {

        AuthUser authUser = new AuthUser();
        authUser.setUsername("我是熔断");
        return JSON.toJSON(new ResponseResult<>(200004,authUser)).toString();
    }

    @Override
    public String updateUser(UserParam userParam) {
        return JSON.toJSON(new ResponseResult<Void>(20004,"您的网络存在异常")).toString();
    }
}
