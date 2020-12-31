package com.zhou.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 角色-权限关联关系表(SysResourcesRoleRelation)实体类
 *
 * @author makejava
 * @since 2020-12-31 10:57:34
 */
@Data
public class SysResourcesRoleRelation implements  Serializable {
    private static final long serialVersionUID = 154943221926368596L;
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 角色id
     */
    private Integer roleId;
    /**
     * 资源id
     */
    private Integer resourcesId;

}