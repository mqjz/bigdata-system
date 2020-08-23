package com.goodix.hi.bigdata.system.controller;

import com.goodix.hi.bigdata.system.entity.UserInfo;
import com.goodix.hi.bigdata.system.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public boolean login(UserInfo user) {
        if (user == null || user.getId() == null) {
            return false;
        }

        UserInfo userInfo = userService.selectByPrimaryKey(user.getId());
        return userInfo != null;
    }
}
