package com.zhou.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @version 0.1
 * @Description 请求路径实体
 * @Author houjun
 * @Date 2020/4/19 21:20
 */
@Data
public class SysRequestPath implements Serializable {

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 请求路径
     */
    private String url;

    /**
     * 路径描述
     */
    private String description;

}
