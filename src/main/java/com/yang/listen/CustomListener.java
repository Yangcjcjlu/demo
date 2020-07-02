package com.yang.listen;

import org.springframework.context.ApplicationListener;

public class CustomListener implements ApplicationListener<CustomApplicationEvent> {

    @Override
    public void onApplicationEvent(CustomApplicationEvent customApplicationEvent) {
        System.out.println("ApplicatopnEvent:"+customApplicationEvent.getClass().getName());
    }
}
