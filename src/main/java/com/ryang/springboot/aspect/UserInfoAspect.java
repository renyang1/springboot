package com.ryang.springboot.aspect;

import com.sun.org.apache.regexp.internal.RE;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @Auther: renyang
 * @Date: 2019/7/2 11:45
 * @Description: 用户信息切面
 */
@Aspect
@Component
public class UserInfoAspect {

    // 定义日志对象
    private Logger logger = LoggerFactory.getLogger(getClass());
    // 定义根据id查询的切点
    private static final String SELECTPOINTBYID = "execution(public * com.ryang.springboot.web.UserInfoController.selectById(..))";

    @Before(value = SELECTPOINTBYID)
    public void doBeforeSelectById(JoinPoint joinPoint) throws Exception{
        // 前置通知，记录请求参数及开始时间
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录请求内容
        logger.info("URL: " + request.getRequestURL().toString());
        logger.info("IP: " + request.getRemoteAddr());
        logger.info("args: " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(value = SELECTPOINTBYID, returning = "result")
    public void doAfterReturning(Object result) throws Exception {
        // 处理完请求，记录返回内容
        logger.info("请求结果： " + result);
    }

}
