package com.fss.ums.config;

import com.fss.common.config.BaseRedisConfig;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * Redis相关配置
 */
@EnableCaching // SpringCaching
@Configuration
public class RedisConfig extends BaseRedisConfig {

}
