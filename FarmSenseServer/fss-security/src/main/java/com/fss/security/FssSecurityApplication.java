package com.fss.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="com.fss")
public class FssSecurityApplication {
    public static void main(String[] args) {
        SpringApplication.run(FssSecurityApplication.class, args);
    }
}
