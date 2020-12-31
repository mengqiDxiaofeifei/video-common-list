package com.zhou.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户角色表(SysRole)实体类
 *
 * @author makejava
 * @since 2020-12-31 10:57:37
 */
@Data
public class SysRole implements  Serializable {
    private static final long serialVersionUID = -83149921554557083L;
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 角色码
     */
    private String roleCode;
    /**
     * 角色名
     */
    private String roleName;
    /**
     * 角色说明
     */
    private String roleDescription;

}