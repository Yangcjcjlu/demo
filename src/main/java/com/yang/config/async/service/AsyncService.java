package com.yang.config.async.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

//练习springBoot
@Service
public class AsyncService {
    public static final Logger logger = LoggerFactory.getLogger(AsyncService.class);

    private List<String> movies =
            new ArrayList<>(
                    Arrays.asList(
                            "Forrest Gump",
                            "Titanic",
                            "Spirited Away",
                            "The Shawshank Redemption",
                            "Zootopia",
                            "Farewell ",
                            "Joker",
                            "Crawl"));


    /** 示范使用：找到特定字符/字符串开头的电影 */

    @Async
    public void completableFutureTask(String start){
        // 打印日志
        logger.warn(Thread.currentThread().getName()+" start this task!");
        // 找到特定字符/字符串开头的电影
        List<String> results = movies.stream().filter(movie->movie.startsWith(start))
                .collect(Collectors.toList());

        // 模拟这是一个耗时的任务
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //返回一个已经用给定值完成的新的CompletableFuture。
//        return CompletableFuture.completedFuture(results);

    }

//    @Async
//    public CompletableFuture<List<String>> completableFutureTask(String start){
//        // 打印日志
//        logger.warn(Thread.currentThread().getName()+" start this task!");
//        // 找到特定字符/字符串开头的电影
//        List<String> results = movies.stream().filter(movie->movie.startsWith(start))
//                .collect(Collectors.toList());
//
//        // 模拟这是一个耗时的任务
//        try {
//            Thread.sleep(1000L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        //返回一个已经用给定值完成的新的CompletableFuture。
//        return CompletableFuture.completedFuture(results);
//
//    }
}
