package com.goodix.hi.bigdata.system.mapper;

import com.goodix.hi.bigdata.system.dao.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    @Select("select * from user where id = #{id}")
    User slelctUser(int id);

}
