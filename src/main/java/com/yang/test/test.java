package com.yang.test;

/**
 * @author: yangcj
 * @date: 2020/6/19 9:47 下午
 * @description:
 */
public class test {

    public static void main(String[] args) {
        //设定操作的商品
        Context context = new Context("iphone X");

        //进行补仓操作
        State reverseState = new Reverstate();
        reverseState.doAction(context);

        context.getState().toString();

        //进行减货操作
        State deduceState = new DeduceState();
        deduceState.doAction(context);

        context.getState().toString();


    }
}
