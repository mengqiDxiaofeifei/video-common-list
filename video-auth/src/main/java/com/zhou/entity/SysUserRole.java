package com.zhou.entity;

import lombok.Data;

/**
 * SysUserRole
 *
 * @author zhouhoujun
 * @date 2020/8/14
 */
@Data
public class SysUserRole {

    /**
     * id
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 角色id
     */
    private Integer roleId;

}
