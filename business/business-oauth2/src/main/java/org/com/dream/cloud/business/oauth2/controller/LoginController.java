package org.com.dream.cloud.business.oauth2.controller;

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.Response;
import org.apache.catalina.authenticator.SpnegoAuthenticator;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.http.HttpStatus;
import org.com.dream.cloud.admin.api.entity.AuthUser;
import org.com.dream.cloud.admin.api.service.IAuthUserService;
import org.com.dream.cloud.business.oauth2.dto.LoginParam;
import org.com.dream.cloud.business.oauth2.dto.UserInfo;
import org.com.dream.cloud.business.profileFeign.ProfileFeign;

import org.com.dream.cloud.commons.api.dto.ResponseResult;
import org.com.dream.cloud.commons.api.utils.OkHttp3Utils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.Principal;
import java.util.*;

@RestController
public class LoginController {


    private static final String URL_OAUTH_TOKEN = "http://localhost:9080/oauth/token";

    @Value("${business.oauth2.grant_type}")
    public String oauth2GrantType;

    @Value("${business.oauth2.client_id}")
    public String oauth2ClientId;

    @Value("${business.oauth2.client_secret}")
    public String oauth2ClientSecret;

    @Resource(name = "userDetailsServiceBean")
    public UserDetailsService userDetailsService;

    @Resource
    public BCryptPasswordEncoder passwordEncoder;

    @Resource
    private TokenStore tokenStore;

    @Resource
    public ProfileFeign profileFeign;




    @RequestMapping("/user/login")
    public ResponseResult<Map<String,Object>> login(@RequestBody LoginParam loginParam)  {
        Map<String, Object> result = new HashMap<>();
        UserDetails userDetails =  userDetailsService.loadUserByUsername(loginParam.getUsername());
        if (ObjectUtils.isEmpty(userDetails) || !passwordEncoder.matches(loginParam.getPassword(), userDetails.getPassword())){
            return new ResponseResult<Map<String,Object>>(HttpStatus.SC_ACCEPTED,"账号密码错误");
        }
//        Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Map<String, String> params = Maps.newHashMap();
        params.put("username", loginParam.getUsername());
        params.put("password", loginParam.getPassword());
        params.put("grant_type", oauth2GrantType);
        params.put("client_id", oauth2ClientId);
        params.put("client_secret", oauth2ClientSecret);
        Response response = OkHttp3Utils.getInstance().postData(URL_OAUTH_TOKEN, params);
        String jsonString = null;
        try {
            jsonString = Objects.requireNonNull(response.body()).string();
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(jsonString, JsonObject.class);

            String token = jsonObject.get("access_token").getAsString();
            result.put("token", token);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseResult<Map<String,Object>>(20000,"").setData(result);
    }

    @GetMapping("/user/info")
    public ResponseResult<UserInfo> userinfo(HttpServletRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserInfo userInfo = new UserInfo();
        userInfo.setName(authentication.getName());
        JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement = jsonParser.parse(profileFeign.userInfo(authentication.getName()));
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        JsonObject jsondata = jsonObject.get("data").getAsJsonObject();
        Gson gson = new Gson();
        AuthUser authUser = gson.fromJson(jsondata, AuthUser.class);
        User user = (User) authentication.getPrincipal();

        List<String> roles = new ArrayList<>();
        user.getAuthorities().forEach( ele ->{
            roles.add(ele.getAuthority());
        });
        userInfo.setRoles(roles);
        userInfo.setName(authUser.getUsername());
        return  new ResponseResult<>(20000,"", userInfo);
    }

    @PostMapping(value = "/user/logout")
    public ResponseResult<Void> logout(HttpServletRequest request) {
        // 获取 token
        String token = request.getParameter("access_token");
        // 删除 token 以注销
        OAuth2AccessToken oAuth2AccessToken = tokenStore.readAccessToken(token);
        tokenStore.removeAccessToken(oAuth2AccessToken);
        return new ResponseResult<Void>(ResponseResult.CodeStatus.OK, "用户已注销");
    }
}
