package com.ryang.springboot.mapper.ryang;

import com.ryang.springboot.pojo.UserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Auther: renyang
 * @Date: 2019/7/1 16:46
 * @Description:
 */
public interface UserInfoMapper {
    /**
     * 根据用户id查询用户信息
     * */
    UserInfo selectById(Integer userId);
}
