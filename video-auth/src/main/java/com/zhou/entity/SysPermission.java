package com.zhou.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @version 0.1
 * @Description 权限表实体
 * @Author houjun
 * @Date 2020/4/19 21:15
 */
@Data
public class SysPermission implements Serializable {

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 权限code
     */
    private String permissionCode;

    /**
     * 权限名
     */
    private String permissionName;
}
