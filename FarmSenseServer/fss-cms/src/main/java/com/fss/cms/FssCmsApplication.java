package com.fss.cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.fss")
public class FssCmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(FssCmsApplication.class, args);
    }
}