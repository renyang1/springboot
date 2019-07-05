package com.ryang.springboot.web;

import com.github.pagehelper.PageInfo;
import com.ryang.springboot.pojo.UserInfo;
import com.ryang.springboot.response.Result;
import com.ryang.springboot.response.ResultGenerator;
import com.ryang.springboot.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        return userInfo;
    }

    @PostMapping("/userInfoList")
    public Result<UserInfo> userInfoList(@RequestParam(defaultValue = "0") Integer page,
                                         @RequestParam(defaultValue = "0") Integer size){
        PageInfo<UserInfo> pageInfo = userInfoService.userInfoList(page, size);
        return ResultGenerator.genOkResult(pageInfo);
    }
}
