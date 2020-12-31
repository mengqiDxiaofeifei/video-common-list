package com.zhou.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 角色-权限关联关系表(SysRolePermissionRelation)实体类
 *
 * @author makejava
 * @since 2020-12-31 10:57:41
 */
@Data
public class SysRolePermissionRelation implements  Serializable {
    private static final long serialVersionUID = -20008778573538578L;
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 角色id
     */
    private Integer roleId;
    /**
     * 权限id
     */
    private Integer permissionId;

}