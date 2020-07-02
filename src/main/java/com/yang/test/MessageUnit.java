package com.yang.test;

/**
 * @author: yangcj
 * @date: 2020/6/30 4:57 下午
 * @description:
 */
public class MessageUnit {

    private String message;

   public MessageUnit(String message){
       this.message = message;
   }

   public String printMessage(){
       System.out.println(message);
       return message;
   }



}
