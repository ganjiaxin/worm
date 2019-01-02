package com.data.config;



import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;


/**
 * @author : ganjiaxin
 * create at:  2018/12/27  6:00 PM
 * @description:springboot异步线程池配置
 */
@Configuration
@EnableAsync
public class AsyncConfig  {


    @Bean
    public Executor getExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(100);
        executor.setQueueCapacity(250);
        executor.initialize();
        return executor;
    }



}

