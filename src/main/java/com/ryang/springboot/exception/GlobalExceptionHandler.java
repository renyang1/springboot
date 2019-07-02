package com.ryang.springboot.exception;

import com.ryang.springboot.response.Result;
import com.ryang.springboot.response.ResultGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Auther: renyang
 * @Date: 2019/7/2 17:00
 * @Description: 全局异常处理器
 */
@RestControllerAdvice
@ControllerAdvice
public class GlobalExceptionHandler {

    // 定义日志对象
    private Logger logger = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result<?> exception(final Exception e) {
        logger.error("未知异常", e);
        return ResultGenerator.genFailedResult(e.getMessage());
    }

    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public Result<?> myException(final MyException e) {
        logger.error("自定义异常", e);
        return ResultGenerator.genFailedResult(e.getMessage());
    }

}
