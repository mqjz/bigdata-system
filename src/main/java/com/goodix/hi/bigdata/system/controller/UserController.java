package com.goodix.hi.bigdata.system.controller;

import com.goodix.hi.bigdata.system.dao.User;
import com.goodix.hi.bigdata.system.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    User selectUser(@PathVariable int id) {
        return userService.selectUser(id);
    }
}
