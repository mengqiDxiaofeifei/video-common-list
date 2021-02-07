package com.zhou.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * (SysResources)实体类
 *
 * @author makejava
 * @since 2020-12-31 10:57:29
 */
@Data
public class SysResources implements Serializable {
    private static final long serialVersionUID = -97730733731539761L;

    private Integer id;
    /**
     * 资源名称
     */
    private String name;
    /**
     * 资源CODE
     */
    private String code;
    /**
     * 资源路径
     */
    private String url;
    /**
     * 父级资源ID
     */
    private Integer pid;
    /**
     * 顺序
     */
    private Integer sort;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 备注
     */
    private String remake;

    /**
     * [扩展] 图标
     */
    private SysMeta meta;
    /**
     * [扩展] 子资源
     */
    private List<SysResources> children;

}