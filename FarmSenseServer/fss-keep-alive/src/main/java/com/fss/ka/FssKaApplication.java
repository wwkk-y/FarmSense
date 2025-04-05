package com.fss.ka;

import com.fss.ka.service.WebSocketService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = "com.fss")
public class FssKaApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(FssKaApplication.class, args);
        WebSocketService.applicationContext = applicationContext;
    }
}