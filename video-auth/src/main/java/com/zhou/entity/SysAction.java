package com.zhou.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (SysAction)实体类
 *
 * @author makejava
 * @since 2020-12-31 10:57:19
 */
@Data
public class SysAction implements Serializable {
    private static final long serialVersionUID = 468133386498859622L;

    private Integer id;
    /**
     * 功能名称
     */
    private String name;
    /**
     * 功能权限Code
     */
    private String code;
}