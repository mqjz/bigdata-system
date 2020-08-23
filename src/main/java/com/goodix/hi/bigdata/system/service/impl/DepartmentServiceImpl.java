package com.goodix.hi.bigdata.system.service.impl;

import com.goodix.hi.bigdata.system.dao.DepartmentDao;
import com.goodix.hi.bigdata.system.entity.Department;
import com.goodix.hi.bigdata.system.service.DepartmentService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Resource
    private DepartmentDao departmentDao;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return departmentDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Department record) {
        if (StringUtils.isEmpty(record.getName())) {
            return departmentDao.insert(record);
        } else {
            Department department = departmentDao.selectByPrimaryName(record.getName());
            if (department == null) {
                return departmentDao.insert(record);
            } else {
                return -1;
            }
        }
    }

    @Override
    public int insertSelective(Department record) {
        return departmentDao.insertSelective(record);
    }

    @Override
    public Department selectByPrimaryKey(Integer id) {
        return departmentDao.selectByPrimaryKey(id);
    }

    @Override
    public Department selectByPrimaryName(String name) {
        return departmentDao.selectByPrimaryName(name);
    }

    @Override
    public int updateByPrimaryKeySelective(Department record) {
        return departmentDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Department record) {
        return departmentDao.updateByPrimaryKey(record);
    }

    @Override
    public List<Department> selectAllDepartment() {
        return departmentDao.selectAllDepartment();
    }
}
