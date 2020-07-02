package com.yang.test;

/**
 * @author: yangcj
 * @date: 2020/6/19 9:16 上午
 * @description:
 */

//定义一个补库存的实现类
public class Reverstate implements State {
    @Override
    public void doAction(Context context) {
        System.out.println("商品准备补库存");
        context.setState(this);

        //执行商品补货的
    }

    @Override
    public String toString(){
        return "Revert State";
    }
}
