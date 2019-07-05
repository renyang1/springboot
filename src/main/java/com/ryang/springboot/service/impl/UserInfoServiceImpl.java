package com.ryang.springboot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ryang.springboot.mapper.ryang.UserInfoMapper;
import com.ryang.springboot.pojo.UserInfo;
import com.ryang.springboot.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public PageInfo<UserInfo> userInfoList(Integer page, Integer size) {
        // 给分页插件设置当前页码、页大小
        PageHelper.startPage(page,size);
        List<UserInfo> userInfoList;
        userInfoList = userInfoMapper.userInfoList();
        // 将查询结果放到分页查询结果信息
        PageInfo<UserInfo> pageInfo = new PageInfo<>(userInfoList);
        return pageInfo;
    }
}
