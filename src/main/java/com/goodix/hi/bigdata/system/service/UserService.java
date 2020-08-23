package com.goodix.hi.bigdata.system.service;

import com.goodix.hi.bigdata.system.mapper.UserMapper;
import com.goodix.hi.bigdata.system.dao.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    UserMapper userMapper;

    public User selectUser(int id) {
        User u = userMapper.slelctUser(id);
        return u;
    }
}
