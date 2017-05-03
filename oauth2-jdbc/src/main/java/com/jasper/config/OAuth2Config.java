package com.jasper.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Created by jjiang153 on 2017/5/3.
 */

@Configuration
@EnableAuthorizationServer
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager auth;

    @Autowired
    private DataSource dataSource;

    @Bean // 声明TokenStore实现
    public JdbcTokenStore tokenStore() {
        return new JdbcTokenStore(dataSource);
    }
    @Bean
    protected AuthorizationCodeServices authorizationCodeServices() {
        return new JdbcAuthorizationCodeServices(dataSource);
    }


    @Override // 配置框架应用上述实现
    public void configure(AuthorizationServerEndpointsConfigurer endpoints)
            throws Exception {
            endpoints.authorizationCodeServices(authorizationCodeServices())
                    .authenticationManager(auth).tokenStore(tokenStore())
                    .approvalStoreDisabled();
    }


    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.jdbc(dataSource).withClient("clientapp")
                .authorizedGrantTypes("client_credentials")
                .scopes("read", "write")
                .resourceIds("resourceid")
                .secret("123456")
                .and()
                .withClient("clientpassword")
                .authorizedGrantTypes("password")
                .authorities("USER")
                .scopes("read")
                .resourceIds("resourceid")
                .secret("123456");
    }



    @Override
    public void configure(
            AuthorizationServerSecurityConfigurer oauthServer)
            throws Exception {
        oauthServer
                .tokenKeyAccess("permitAll()");
    }




}
