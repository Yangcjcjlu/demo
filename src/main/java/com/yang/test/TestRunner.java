package com.yang.test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * @author: yangcj
 * @date: 2020/6/30 5:09 下午
 * @description:
 */
public class TestRunner {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestUnit.class);
        for(Failure failure : result.getFailures()){
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }
}
