package com.goodix.hi.bigdata.system.service;

import com.goodix.hi.bigdata.system.entity.Department;

import java.util.List;

public interface DepartmentService {

    int deleteByPrimaryKey(Integer id);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer id);

    Department selectByPrimaryName(String name);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    List<Department> selectAllDepartment();
}
