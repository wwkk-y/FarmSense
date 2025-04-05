package com.fss.security.config;

import com.fss.common.config.BaseRedisConfig;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

@EnableCaching // SpringCaching
@Configuration
public class SecurityRedisConfig extends BaseRedisConfig {
}
