package com.fss.security.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.fss.security.mapper")
public class SecurityMyBatisConfig {
}