package com.luq89.smartfridge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class SmartFridgeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartFridgeApplication.class, args);
    }

}
