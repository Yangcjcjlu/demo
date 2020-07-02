package com.yang.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Controller {

    private Logger logger = LoggerFactory.getLogger(Controller.class);


    @RequestMapping("/hello")
    public String getHello() throws InterruptedException{
        Thread.sleep(100);
        logger.info("hello****************hello");
        return "hello";
    }
}
