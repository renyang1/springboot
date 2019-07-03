package com.ryang.springboot.java8;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

/**
 * @Auther: renyang
 * @Date: 2019/7/3 19:17
 * @Description:
 */
public class LocalTimeTest {

    /**
     * Description: 创建LocalTime实例的方式
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/7/3 19:19
     */
    @Test
    public void creat() {
        // 1.获取当前时间
        LocalDateTime dateTime1 = LocalDateTime.now();
        System.out.println(dateTime1.toString());

        // 2.指定时间创建对象
        LocalDateTime dateTime2 = LocalDateTime.of(2019, Month.JULY, 18, 19, 30, 30);
        System.out.println(dateTime2);

        // 3.使用LocalDate、LocalTime创建
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime dateTime3 = LocalDateTime.of(date, time);
        System.out.println("date " + date + "\n" + "time " + time + "\n" + dateTime3);

        // 4.根据日期字符串创建(默认时间格式为yyyy-MM-ddTHH:mm:ss)
        LocalDateTime dateTime4 = LocalDateTime.parse("2019-07-03T19:45:30");
        System.out.println(dateTime4);

        // 5.根据日期字符串创建，且指定时间格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime5 = LocalDateTime.parse("2019-07-03 19:45:30",formatter);
        System.out.println(dateTime5.format(formatter));
    }


}
