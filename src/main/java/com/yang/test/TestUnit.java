package com.yang.test;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author: yangcj
 * @date: 2020/6/30 4:56 下午
 * @description:
 */
public class TestUnit {
    String message = "Hello World";
    MessageUnit messageUnit = new MessageUnit(message);

    @Test
    public void testPrintMessage(){
        message = "New wORD";
        assertEquals(message,messageUnit.printMessage());
    }
}
