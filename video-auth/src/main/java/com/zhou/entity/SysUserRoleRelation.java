package com.zhou.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户角色关联关系表(SysUserRoleRelation)实体类
 *
 * @author makejava
 * @since 2020-12-31 10:57:48
 */
@Data
public class SysUserRoleRelation implements Serializable {
    private static final long serialVersionUID = 950957897959948848L;
    /**
     * 主键id
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