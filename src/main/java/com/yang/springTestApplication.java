package com.yang;

import com.yang.service.OrderService;
import com.yang.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class springTestApplication {

    public static void main(String[] args) {
        //启动spring IOC 容器
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:springData.xml");

        //取Aop代理
        //由于采用了自动代理配置，不需要再根据代理找bean
        UserService userService = context.getBean(UserService.class);
        OrderService orderService = context.getBean(OrderService.class);
//        UserService userService = (UserService) context.getBean("userServiceProxy");

        userService.createUser("TOM","Cruise",55);
        userService.queryUser();

        orderService.createOrder("Leo","随便买点东西");
        orderService.queryOrder("Leo");
    }

}
