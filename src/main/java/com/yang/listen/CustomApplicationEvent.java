package com.yang.listen;

import org.springframework.context.ApplicationEvent;

public class CustomApplicationEvent extends ApplicationEvent {

    public CustomApplicationEvent(Object source){
        super(source);
        System.out.println("CustomApplicationEvent constructor started!!");
    }
}
