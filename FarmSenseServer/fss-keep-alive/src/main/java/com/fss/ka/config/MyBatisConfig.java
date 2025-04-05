package com.fss.ka.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.fss.common.mapper")
public class MyBatisConfig {
}
