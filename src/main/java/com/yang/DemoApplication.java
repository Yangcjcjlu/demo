package com.yang;

import com.yang.listen.CustomApplicationEvent;
import com.yang.listen.CustomListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context =  SpringApplication.run(DemoApplication.class, args);

//		ApplicationContext newContext = new ClassPathXmlApplicationContext("classpath:application.xml");
//		//注册监听器
//		context.addApplicationListener(new CustomListener());
//
//		//发布ApplicationEvent事件
//		context.publishEvent(new CustomApplicationEvent(new Object()));

		System.out.println("系统启动成功！");
	}

}
