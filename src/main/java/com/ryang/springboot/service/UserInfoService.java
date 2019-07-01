package com.ryang.springboot.service;

import com.ryang.springboot.pojo.UserInfo;

/**
 * @Auther: renyang
 * @Date: 2019/7/1 16:59
 * @Description:
 */
public interface UserInfoService {

   UserInfo selectById(Integer userId);
}
