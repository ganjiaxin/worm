package com.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ComponentScan("com.data.*")
@Configuration
@EnableTransactionManagement //开启事务
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class CleanApplication {
    public static void main(String[] args) {
        SpringApplication.run(CleanApplication.class, args);
    }
}

