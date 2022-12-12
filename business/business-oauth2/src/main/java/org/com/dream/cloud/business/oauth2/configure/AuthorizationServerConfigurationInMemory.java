package org.com.dream.cloud.business.oauth2.configure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

import javax.sql.DataSource;


/**
 *   内存模式
 */
@Configuration
@ConditionalOnProperty(value = "base.config.inMemory", havingValue = "true", matchIfMissing = false)
@EnableAuthorizationServer
public class AuthorizationServerConfigurationInMemory extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;



    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        // 用于支持密码模式
        endpoints.authenticationManager((authenticationManager))
                .tokenStore(tokenStore());
    }
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
                // 允许客户端访问 /oauth/check_token  检查 token
                .checkTokenAccess("isAuthenticated()")
                .allowFormAuthenticationForClients();
    }

    /***
     *
     *   in memory
     *
     * @return
     */

    @Bean
    @ConditionalOnProperty(value = "base.config.inMemory", havingValue = "true", matchIfMissing = false)
    public TokenStore tokenStore(){
        return new InMemoryTokenStore();
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients
                .inMemory()
                // client_id
                .withClient("client")
                //client_secret
                .secret(passwordEncoder.encode("secret"))
                // 授权类型 密码模式和 刷新令牌
                .authorizedGrantTypes("password","refresh_token")
                //  授权范围
                .scopes("backend")
                // 可以设置对那些资源有访问权限  ， 不设置全部资源
                .resourceIds("backend-resources")
                // 设置访问令牌的有效期
                .accessTokenValiditySeconds(24 * 60 * 60)
                // 设置刷新令牌的有效期
                .refreshTokenValiditySeconds(30 * 24 * 60 * 60);
    }


















    //    @Bean
//    @Primary
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource dataSource() {
//        // 配置数据源（注意，我使用的是 HikariCP 连接池），以上注解是指定数据源，否则会有冲突
//        return DataSourceBuilder.create().build();
//    }
}
