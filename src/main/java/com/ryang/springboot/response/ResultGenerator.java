package com.ryang.springboot.response;

/**
 * @Auther: renyang
 * @Date: 2019/7/2 17:21
 * @Description: 响应结果生成工具
 */
public class ResultGenerator {

    public static <T> Result<T> genOkResult() {
        return new Result<T>();
    }

    public static Result genOkResult(final Object data) {
        return new Result<Object>(ResultCodeEnum.SUCCESS, data);
    }

    public static Result genFailedResult(final String msg) {
        return new Result<Object>(ResultCodeEnum.OPERATION_FAIL, msg);
    }

    public static Result genInternalServerErrorResult(final String url) {
        return new Result<Object>(ResultCodeEnum.SYSTEM_ERROR, "API [" + url + "] internal server error. Please call engineer to debug.");
    }
}
