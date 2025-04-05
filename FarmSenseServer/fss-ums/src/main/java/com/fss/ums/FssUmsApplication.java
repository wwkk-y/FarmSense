package com.fss.ums;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wyz
 */
@SpringBootApplication(scanBasePackages="com.fss")
public class FssUmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(FssUmsApplication.class, args);
    }
}