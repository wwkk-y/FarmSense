package com.fss.common.config;

import com.fss.common.util.RocketMQSendUtil;
import org.springframework.context.annotation.Bean;

public class BaseRocketMQConfig {
    @Bean
    public RocketMQSendUtil rocketMQSendUtil(){
        return new RocketMQSendUtil();
    }
}
