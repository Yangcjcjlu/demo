package com.yang.test;

/**
 * @author: yangcj
 * @date: 2020/6/19 9:14 上午
 * @description:
 */
public class Context {

    private State state;
    private String name;

    public Context(String name){
        this.name = name;
    }

    public void setState(State state){
        this.state = state;
    }

    public State getState(){
        return this.state;
    }

}
