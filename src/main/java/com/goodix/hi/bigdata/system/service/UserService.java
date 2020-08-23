package com.goodix.hi.bigdata.system.service;

import com.goodix.hi.bigdata.system.entity.UserInfo;

import java.util.List;

public interface UserService {

    int deleteByPrimaryKey(Integer id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    List<UserInfo> selectByDeptId(int deptId);
}
