package org.com.dream.cloud.business.profileFeign;

import org.com.dream.cloud.business.dto.UserParam;
import org.com.dream.cloud.business.profileFeign.fallback.ProfileFeignFallback;
import org.com.dream.cloud.configuration.FeignRequestConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "business-profile-feign", path = "profile"
        ,configuration = FeignRequestConfig.class, fallback = ProfileFeignFallback.class)
public interface ProfileFeign {

    @GetMapping(value = "/user/{userName}")
    String userInfo(@PathVariable("userName") String userName);

    @PostMapping(value = "/users")
    String updateUser(@RequestBody UserParam userParam);
}
