package com.yang.test;

/**
 * @author: yangcj
 * @date: 2020/6/19 9:16 上午
 * @description:
 */

//定义一个减库存的实现类
public class DeduceState implements State {
    @Override
    public void doAction(Context context) {
        System.out.println("商品卖出，准备减库存！");
        context.setState(this);


        //执行减少库存的具体操作
    }

    @Override
    public String toString() {
        return "Deduct State";
    }
}
