package com.goodix.hi.bigdata.system.controller;

import com.goodix.hi.bigdata.system.entity.Department;
import com.goodix.hi.bigdata.system.service.DepartmentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Resource
    DepartmentService departmentService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public int addDepartment(Department department) {
        return departmentService.insert(department);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Department> listDepartment() {
        return departmentService.selectAllDepartment();
    }
}
