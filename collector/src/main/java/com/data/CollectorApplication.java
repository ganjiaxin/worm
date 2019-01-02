package com.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@ComponentScan("com.data.*")
@Configuration
@EnableEurekaClient
@EnableFeignClients
@EnableAsync  //启动异步
@SpringBootApplication
public class CollectorApplication {
    public static void main(String[] args) {
        SpringApplication.run(CollectorApplication.class, args);
    }
}

