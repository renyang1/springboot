package com.ryang.springboot.exception;

/**
 * @Auther: renyang
 * @Date: 2019/7/2 17:45
 * @Description:
 */
public class MyException extends RuntimeException {

    public MyException(String message){
        super(message);
    }
}
