package com.ryang.springboot.response;

/**
 * @Auther: renyang
 * @Date: 2019/7/2 17:23
 * @Description:
 */
public enum ResultCodeEnum {
    SUCCESS(0, "OK"),
    OPERATION_FAIL(-5, "Operation Fail"),
    SYSTEM_ERROR(500, "System Error"),
    EXCEPTION(-1, "System Exception");

    private final int code;
    private final String msg;

    private ResultCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public String toString() {
        return "ResultCodeEnum{code=" + this.code + ", msg='" + this.msg + '\'' + '}';
    }
}
