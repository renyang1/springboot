package com.ryang.springboot.service.impl;

import com.ryang.springboot.mapper.ryang.UserInfoMapper;
import com.ryang.springboot.pojo.UserInfo;
import com.ryang.springboot.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: renyang
 * @Date: 2019/7/1 17:00
 * @Description:
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public UserInfo selectById(Integer userId) {
        UserInfo userInfo = userInfoMapper.selectById(userId);
        return userInfo;
    }
}
