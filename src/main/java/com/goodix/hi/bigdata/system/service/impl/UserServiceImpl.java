package com.goodix.hi.bigdata.system.service.impl;

import com.goodix.hi.bigdata.system.dao.UserInfoDao;
import com.goodix.hi.bigdata.system.entity.UserInfo;
import com.goodix.hi.bigdata.system.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserInfoDao userInfoDao;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userInfoDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UserInfo record) {
        return userInfoDao.insert(record);
    }

    @Override
    public int insertSelective(UserInfo record) {
        return userInfoDao.insertSelective(record);
    }

    @Override
    public UserInfo selectByPrimaryKey(Integer id) {
        return userInfoDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UserInfo record) {
        return userInfoDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserInfo record) {
        return userInfoDao.updateByPrimaryKey(record);
    }

    @Override
    public List<UserInfo> selectByDeptId(int deptId) {
        return userInfoDao.selectByDeptId(deptId);
    }
}
