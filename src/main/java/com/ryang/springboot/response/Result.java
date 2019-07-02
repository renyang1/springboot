package com.ryang.springboot.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: renyang
 * @Date: 2019/7/2 17:09
 * @Description: 返回结果定义类
 */
@Data
public class Result<T> implements Serializable {
    public static final Integer OK = 0; //成功
    public static final Integer ERROR = -1;// 失败

    private Integer code;// 状态码
    private String message;// 失败信息
    private T data;// 成功返回数据

    public Result() {
        this(ResultCodeEnum.SUCCESS);
    }

    public Result(ResultCodeEnum resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMsg();
    }

    public Result(ResultCodeEnum resultCode, T data) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMsg();
        this.data = data;
    }

    public Result(ResultCodeEnum resultCode, String msg, T data) {
        this.code = resultCode.getCode();
        this.message = msg;
        this.data = data;
    }
}
