package com.fss.ums.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.fss.ums.mapper")
public class MyBatisConfig {
}
