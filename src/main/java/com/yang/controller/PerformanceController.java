package com.yang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PerformanceController {

    /**
     * 模拟CP占满的情况
     * @throws InterruptedException
     */
    @GetMapping("/cpu/loop")
    public void testCpuLoop() throws InterruptedException{
        System.out.println("请求cpu死循环");
        Thread.currentThread().setName("loop-thread-cpu");
        int num = 0;
        while (true){
            num++;
            if (num==Integer.MAX_VALUE){
                System.out.println("reset");
            }
            num=0;
        }
    }
}
