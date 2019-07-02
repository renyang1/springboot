package com.ryang.springboot.web;

import com.ryang.springboot.pojo.UserInfo;
import com.ryang.springboot.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: renyang
 * @Date: 2019/7/1 16:57
 * @Description:
 */
@RestController
@RequestMapping("/userInfo")
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    @PostMapping("/getUserInfo")
    public UserInfo selectById(Integer userId) {
        UserInfo userInfo = userInfoService.selectById(userId);
        int i = 2/0;
        System.out.println(i);
        return userInfo;
    }
}
