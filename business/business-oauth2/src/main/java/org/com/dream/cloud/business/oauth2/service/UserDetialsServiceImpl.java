package org.com.dream.cloud.business.oauth2.service;

import com.google.common.collect.Lists;
import org.apache.dubbo.config.annotation.DubboReference;
import org.com.dream.cloud.admin.api.entity.AuthUser;
import org.com.dream.cloud.admin.api.service.IAuthUserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDetialsServiceImpl implements UserDetailsService {

    private static final String NAME = "admin";
    private static final String PASSWORD = "$2a$10$4OkOBis.NLLEOydPKwc1KOAQPl6dGYjJlkw7gLl3bxRRPkQ0EYCza";

    @DubboReference(version = "0.0.1")
    private IAuthUserService authUserService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("user");
        grantedAuthorities.add(grantedAuthority);
        AuthUser authUser = authUserService.selectByName(s);
        if (authUser != null){
            return new User(authUser.getUsername(),authUser.getPassword(), grantedAuthorities);
        }
        return null;
    }
}
