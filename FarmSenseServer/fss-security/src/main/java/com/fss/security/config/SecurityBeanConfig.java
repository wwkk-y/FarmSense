package com.fss.security.config;

import com.fss.security.filter.JwtAuthenticationTokenFilter;
import com.fss.security.handler.SecurityExceptionHandler;
import com.fss.security.util.AccountUtil;
import com.fss.security.util.JWTUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * SpringSecurity通用配置
 * 包括通用Bean、Security通用Bean及动态权限通用Bean
 */
@Configuration
public class SecurityBeanConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public IgnoreUrlsConfig ignoreUrlsConfig() {
        return new IgnoreUrlsConfig();
    }

    @Bean
    public JWTUtil JWTUtil() {
        return new JWTUtil();
    }

    @Bean
    public SecurityExceptionHandler restfulAccessDeniedHandler() {
        return new SecurityExceptionHandler();
    }

    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter() {
        return new JwtAuthenticationTokenFilter();
    }

    @Bean
    public AccountUtil securityUtil(){
        return new AccountUtil();
    }
}