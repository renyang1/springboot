package com.ryang.springboot.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @Auther: renyang
 * @Date: 2019/6/28 17:23
 * @Description:
 */
@Data
public class UserInfo {

    private Integer userId;
    /**
     * 账户：暂定手机号
     */
    private String account;

    /**
     * 昵称，默认注册账户
     */
    private String nickName;
    private String remarkName;
    private Integer age;
    /**
     * 出生年月（2019-02-01）
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthMonth;
    private String headUrl;
    /**
     * 注册日期(2018-10-20 22:37:13)
     * */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date registerDate;
    private String registerIp;
    /**
     * 地址：省份（用作区域筛选，冗余信息）
     */
    private String province;
    /**
     * 地址：城市
     */
    private String city;
    /**
     * 地址：地区
     */
    private String area;
    /**
     * 详细地址
     */
    private String detailAddress;
    /**
     * 男，女，未知
     */
    private String sex;
}
