package com.yang.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;


@Configuration
@EnableAsync
public class AsyncConfig implements AsyncConfigurer {


    private static final int CORE_POOL_SIZE = 6;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 100;

    public Executor taskExecutor(){

        // Spring 默认配置是核心线程数大小为1，最大线程容量大小不受限制，队列容量也不受限制。
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();

        //核心线程数
        threadPoolTaskExecutor.setCorePoolSize(CORE_POOL_SIZE);

        // 最大线程数
        threadPoolTaskExecutor.setMaxPoolSize(MAX_POOL_SIZE);

        // 队列大小
        threadPoolTaskExecutor.setQueueCapacity(QUEUE_CAPACITY);

        // 当最大池已满时，此策略保证不会丢失任务请求，但是可能会影响应用程序整体性能。
        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        threadPoolTaskExecutor.setThreadNamePrefix("my_threadPoolTaskExecutor-");
        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;
    }
}
