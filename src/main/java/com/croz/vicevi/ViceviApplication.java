package com.croz.vicevi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class ViceviApplication {

    public static void main(String[] args) {
        SpringApplication.run(ViceviApplication.class, args);
    }
}
