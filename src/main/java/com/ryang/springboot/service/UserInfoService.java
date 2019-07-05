package com.ryang.springboot.service;

import com.github.pagehelper.PageInfo;
import com.ryang.springboot.pojo.UserInfo;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Auther: renyang
 * @Date: 2019/7/1 16:59
 * @Description:
 */
public interface UserInfoService {

   UserInfo selectById(Integer userId);

   PageInfo<UserInfo> userInfoList(@RequestParam(defaultValue = "0") Integer page,
                                   @RequestParam(defaultValue = "0") Integer size);
}
