package com.fss.cms.config;

import com.fss.common.config.BaseSwaggerConfig;
import com.fss.common.domain.SwaggerProperties;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger相关配置
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {

    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("com.fss.cms.controller") // 接口扫描路径
                .title("FarmSense后台-cms模块") // 标题
                .description("FarmSense后台相关接口文档") //  描述
                .contactName("cms") //  关系名
                .version("1.0") // 版本
                .enableSecurity(true)
                .build();
    }

    @Bean
    public BeanPostProcessor springfoxHandlerProviderBeanPostProcessor() {
        return generateBeanPostProcessor();
    }

}
