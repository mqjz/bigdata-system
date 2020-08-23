package com.goodix.hi.bigdata.system.controller;

import com.goodix.hi.bigdata.system.entity.UserInfo;
import com.goodix.hi.bigdata.system.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    UserInfo selectUser(@PathVariable int id) {
        return userService.selectByPrimaryKey(id);
    }

    @RequestMapping(value = "/dept/{deptId}", method = RequestMethod.GET, produces = "application/json")
    List<UserInfo> selectUserByDepartmentId(@PathVariable int deptId) {
        return userService.selectByDeptId(deptId);
    }
}
