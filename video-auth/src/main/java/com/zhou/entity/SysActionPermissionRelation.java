package com.zhou.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 路径权限关联表(SysActionPermissionRelation)实体类
 *
 * @author makejava
 * @since 2020-12-31 10:57:22
 */
@Data
public class SysActionPermissionRelation implements  Serializable {
    private static final long serialVersionUID = -82609177130610531L;
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 功能id
     */
    private Integer actionId;
    /**
     * 权限id
     */
    private Integer permissionId;

}