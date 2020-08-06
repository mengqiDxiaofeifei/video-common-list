package com.zhou.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @version 0.1
 * @Description 路径权限关联表实体
 * @Author houjun
 * @Date 2020/4/19 21:24
 */
@Data
public class SysRequestPathPermissionRelation implements Serializable {

    private Integer id;

    private Integer urlId;

    private Integer permissionId;
}
