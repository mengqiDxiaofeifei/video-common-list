package com.zhou.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (SysMeta)实体类
 *
 * @author makejava
 * @since 2021-01-05 10:30:16
 */
@Data
public class SysMeta implements Serializable {
    private static final long serialVersionUID = -56111470203092359L;

    private Integer id;
    /**
     * 名称
     */
    private String title;
    /**
     * 图标
     */
    private String icon;


}