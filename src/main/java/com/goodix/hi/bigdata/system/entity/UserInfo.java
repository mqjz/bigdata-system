package com.goodix.hi.bigdata.system.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * user_info
 * @author
 */
@Data
public class UserInfo implements Serializable {
    private Integer id;

    private String name;

    private String password;

    private Integer deptId;

    private static final long serialVersionUID = 1L;
}
