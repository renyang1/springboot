package com.ryang.springboot.java8;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * @Auther: renyang
 * @Date: 2019/7/3 09:57
 * @Description:
 */
public class LocalDateTest {

    /**
     * Description: 创建LocalDate实例的方式
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/7/3 14:38
     */
    @Test
    public void creat(){
        // 1. 指定年月日创建对象
        LocalDate date1 = LocalDate.of(2019,7, 1);
        System.out.println(date1);

        // 2. 获取当前日期
        LocalDate date2 = LocalDate.now();
        System.out.println(date2);

        // 3. 根据日期字符串创建LocalDate对象
        LocalDate date3 = LocalDate.parse("2019-07-03");
        System.out.println(date3);

        // 4. 根据日期字符串创建LocalDate对象，且使用日期格式化对象进行格式化
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        LocalDate date4 = LocalDate.parse("2019年07月04日",formatter);
        System.out.println(date4);

        // 5. 从LocalDateTime获取
        LocalDateTime dateTime1 = LocalDateTime.now();
        System.out.println(dateTime1.toString());
        LocalDate date5 = dateTime1.toLocalDate();
        System.out.println(date5);
    }

    /**
     * Description: 获取LocalDate对象中的年、月、日等值
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/7/3 14:37
     */
    @Test
    public void getLOcalDateValue(){
        // 创建指定日期的日期对象
        LocalDate date = LocalDate.now();
        System.out.println(date);

        System.out.println(date.getYear());// 得到当前年份
        Month month = date.getMonth();// 得到当前月份枚举值对象
        int monthValue = month.getValue();// 根据ordinal(枚举值序号，从0开始)来确定枚举的值
        System.out.println(monthValue);
        System.out.println(date.getDayOfMonth());// 获取当前月份值
        DayOfWeek dayOfWeek = date.getDayOfWeek();// 获取当前星期枚举值对象
        System.out.println(dayOfWeek.getValue());// 根绝星期枚举值对象得到星期几

        // 使用TemporalField读取LocalDate的值
        int year = date.get(ChronoField.YEAR);
        System.out.println(year);

        // 将日期以指定格式的字符串形式返回
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        String s = date.format(formatter);
        System.out.println(s);
    }

    /**
     * Description: 利用with相关API操纵LocalDate对象，返回新的LocalDate对象(LocalDate为不可变类)
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/7/3 15:00
     */
    @Test
    public void changeLocalDateByWith() {
        LocalDate date = LocalDate.now();
        System.out.println(date);

        LocalDate date1 = date.withYear(2020);// 修改年的值
        System.out.println(date1);
        LocalDate date2 = date.withDayOfMonth(1);// 月日期的更改
        System.out.println(date2);
        LocalDate date3 = date.withDayOfYear(111);// 年日期的更改
        System.out.println(date3);

        // 使用第一个参数为TemporalField对象的with方法操纵日期对象得到新的日期对象
        LocalDate date4 = date.withMonth(8);
        System.out.println(date4);
        LocalDate date5 = date4.with(ChronoField.DAY_OF_WEEK, 2);
        System.out.println(date5);
    }

    /**
     * Description: 使用重载版的with方法，；利用TemporalAdjuster对象作为参数操纵日期对象，
     *              可以参考API中TemporalAdjusters类的静态方法
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/7/3 16:19
     */
    @Test
    public void changeLocalDateByTemporalAdjuster() {
        LocalDate date = LocalDate.now();
        System.out.println(date);

        LocalDate date1 = date.with(TemporalAdjusters.firstDayOfMonth());// 获得当前日期月份的第一天
        System.out.println(date1);

        LocalDate date2 = date.with(TemporalAdjusters.firstDayOfNextMonth());// // 获得当前日期下月份第一天
        System.out.println(date2);

        // 定制的TemporalAdjuster实现计算下一个工作日
        TemporalAdjuster adjuster = (temporal -> {
            DayOfWeek dayOfWeek = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
            int dayToadd = 1;
            if (dayOfWeek == DayOfWeek.FRIDAY) dayToadd = 3;// 若为星期五，则加3天
            else if (dayOfWeek == DayOfWeek.SATURDAY) dayToadd = 2;// 若为礼拜6，则加2天
            return temporal.plus(dayToadd, ChronoUnit.DAYS);
        });
        LocalDate date3 = date.plus(2, ChronoUnit.DAYS).with(adjuster);
        System.out.println(date3);
    }

    /**
     * Description: 对LocalDate对象加减指定日、周、月、年
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/7/3 15:38
     */
    @Test
    public void increaseOrDecreaseLocalDate() {
        LocalDate date = LocalDate.now();
        System.out.println(date);

        LocalDate date1 = date.minusDays(3);// 当前日期减3天
        System.out.println(date1);
        LocalDate date2 = date.plusMonths(6);// 当前日期加6个月
        System.out.println(date2);
        // 使用带TemporalUnit对象指定计时单位的方法对日期进行加减
        LocalDate date3 = date.plus(6, ChronoUnit.MONTHS);
        System.out.println(date3);
    }

    /**
     * Description:两个日期进行比较
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/7/3 20:57
     */
    @Test
    public void compare(){
        LocalDate date1 = LocalDate.now();
        LocalDate date2 = date1.minusDays(100);
        // 1.使用LocalDate对象的compareTo()方法
        // todo:这里的值怎么算
        int differs = date1.compareTo(date2);// date1 - date2
        System.out.println(differs);
        // todo:这里的值怎么算
        Period period = date1.until(date2);
        System.out.println(period.getDays());

        // 2.使用Period类进行比较
        // todo:这里的值怎么算
        Period period1 = Period.between(date2, date1);
        System.out.println(period1.getMonths());
    }
}
