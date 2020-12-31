package com.zhou.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (SysPermission)实体类
 *
 * @author makejava
 * @since 2020-12-31 10:57:26
 */
@Data
public class SysPermission implements  Serializable {
    private static final long serialVersionUID = -64644346370883897L;

    private Integer id;
    /**
     * 权限名称
     */
    private String name;
    /**
     * 权限CODE
     */
    private String code;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}