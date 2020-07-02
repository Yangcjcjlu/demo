package com.yang.test;

import org.quartz.*;
import org.quartz.impl.StdScheduler;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class QuartzTest implements Job {

    public static void main(String[] args) throws SchedulerException{
        //1. 创建job对象
        JobDetail jobDetail = JobBuilder.newJob(QuartzTest.class).build();

        //2. 创建Trigger 对象
        //两种方式：一种简单的trigger触发时间，通过Quartz提供的一个方法来完成简单的重复，调用cron
        //第二种 Trigger:按照cron的表达式来触发时间
        Trigger trigger = TriggerBuilder.newTrigger().withSchedule(SimpleScheduleBuilder.repeatHourlyForever(2)).build();

        Trigger trigger1 = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?")).build();
        //3.创建Scheduler 对象：在什么时间做什么事
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        scheduler.scheduleJob(jobDetail,trigger);
//        scheduler.scheduleJob(jobDetail,trigger1);

        //启动
        scheduler.start();

    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
        System.out.println("任务调度器"+sdf.format(new Date()));
    }
}
