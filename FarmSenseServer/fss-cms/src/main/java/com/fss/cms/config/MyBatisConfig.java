package com.fss.cms.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.fss.cms.mapper")
public class MyBatisConfig {
}
